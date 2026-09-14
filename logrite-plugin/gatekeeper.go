package main

import (
	"bytes"
	"encoding/json"
	"flag"
	"fmt"
	"io"
	"net/http"
	"os"
	"os/exec"
	"strings"
	"time"
)

// Exit codes are the contract with the workflow:
//
//	0 = allow   — coverage met the threshold
//	1 = block   — coverage below threshold; LogRite opened a fix PR (PR_LINK printed)
//	2 = error   — the check never produced a verdict (no key, auth refused, API down, bad reply)
//
// Anything that is not a verdict must be exit 2. Reporting "missing bearer token" as a coverage
// failure is what made every run since 2026-09-08 look like a logging problem.
const (
	exitAllow = 0
	exitBlock = 1
	exitError = 2
)

type Request struct {
	Branch       string   `json:"branch"`
	BaseCommit   string   `json:"base_commit"`
	Commit       string   `json:"commit"`
	RepoUrl      string   `json:"repoUrl"`
	GithubToken  string   `json:"githubToken"`
	ChangedFiles []string `json:"changedFiles"`
	LogCoverage  string   `json:"logCoverageThreshold"`
}

type Response struct {
	PRLink  string `json:"prLink"`
	Status  string `json:"status"`
	Message string `json:"message"`
}

func getChangedFiles(base, current string) []string {
	out, err := exec.Command("git", "diff", "--name-only", base, current).Output()
	if err != nil {
		fmt.Println("WARNING: could not compute changed files:", err)
		return []string{}
	}
	var files []string
	for _, l := range bytes.Split(bytes.TrimSpace(out), []byte("\n")) {
		if len(l) > 0 {
			files = append(files, string(l))
		}
	}
	return files
}

func fail(format string, args ...any) {
	fmt.Println("STATUS: error")
	fmt.Printf("ERROR: "+format+"\n", args...)
	os.Exit(exitError)
}

func main() {
	branch := flag.String("branch", "", "Branch name")
	base := flag.String("base", "", "Base commit SHA")
	commit := flag.String("commit", "", "Current commit SHA")
	repoURL := flag.String("repoURL", "", "Git Repo URL")
	flag.Parse()

	apiURL := os.Getenv("API_URL")
	if apiURL == "" {
		fail("API_URL is not set")
	}
	// The endpoint requires a bearer. A LogRite CI key (lgck_live_…) is minted per workspace
	// under Settings → Gatekeeper keys and stored as the LOGRITE_API_KEY repository secret.
	ciKey := strings.TrimSpace(os.Getenv("LOGRITE_CI_KEY"))
	if ciKey == "" {
		fail("LOGRITE_CI_KEY is not set — store a LogRite Gatekeeper CI key as the LOGRITE_API_KEY repository secret")
	}
	logCoverage := strings.TrimSpace(os.Getenv("LOG_COVERAGE_THRESHOLD"))
	if logCoverage == "" {
		fail("LOG_COVERAGE_THRESHOLD is not set — define it as a repository variable (e.g. 80)")
	}

	changed := getChangedFiles(*base, *commit)
	fmt.Println("Branch:", *branch)
	fmt.Println("Base commit:", *base)
	fmt.Println("Current commit:", *commit)
	fmt.Println("Changed files:", changed)

	body, err := json.Marshal(Request{
		Branch:       *branch,
		BaseCommit:   *base,
		Commit:       *commit,
		RepoUrl:      *repoURL,
		GithubToken:  os.Getenv("GITHUB_TOKEN"),
		ChangedFiles: changed,
		LogCoverage:  logCoverage,
	})
	if err != nil {
		fail("could not encode the request: %v", err)
	}
	// Never print the request body: it carries GITHUB_TOKEN, and Actions only masks secrets it
	// was told about.

	req, err := http.NewRequest(http.MethodPost, apiURL, bytes.NewReader(body))
	if err != nil {
		fail("could not build the request: %v", err)
	}
	req.Header.Set("Content-Type", "application/json")
	req.Header.Set("Authorization", "Bearer "+ciKey)

	// A block runs a full scan and opens a fix PR before answering, so allow for minutes.
	client := &http.Client{Timeout: 20 * time.Minute}
	res, err := client.Do(req)
	if err != nil {
		fail("could not reach the LogRite API: %v", err)
	}
	defer res.Body.Close()
	raw, _ := io.ReadAll(io.LimitReader(res.Body, 1<<20))

	if res.StatusCode < 200 || res.StatusCode > 299 {
		snippet := string(raw)
		if len(snippet) > 2048 {
			snippet = snippet[:2048]
		}
		fmt.Println("HTTP_STATUS:", res.StatusCode)
		fail("the LogRite API refused the check (HTTP %d): %s", res.StatusCode, snippet)
	}

	var apiResp Response
	if err := json.Unmarshal(raw, &apiResp); err != nil {
		fail("unreadable reply from the LogRite API: %v", err)
	}

	fmt.Println("STATUS:", apiResp.Status)
	fmt.Println("API RESPONSE:", apiResp.Message)

	switch apiResp.Status {
	case "allow":
		os.Exit(exitAllow)
	case "block":
		fmt.Println("❌ Log coverage is below the threshold — LogRite opened a fix PR.")
		fmt.Println("PR_LINK:", apiResp.PRLink)
		os.Exit(exitBlock)
	default:
		fail("the LogRite API returned no verdict (status %q)", apiResp.Status)
	}
}
