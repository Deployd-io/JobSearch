package main

import (
    "bytes"
    "encoding/json"
    "flag"
    "fmt"
    "net/http"
    "os"
    "os/exec"
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
    ScanID      int    `json:"scanId"`
    Status  string `json:"status"`
    Message string `json:"message"`
}

func getChangedFiles(base, current string) []string {
    cmd := exec.Command("git", "diff", "--name-only", base, current)

    out, err := cmd.Output()
    if err != nil {
        fmt.Println("ERROR: Could not compute changed files:", err)
        return []string{}
    }

    lines := bytes.Split(bytes.TrimSpace(out), []byte("\n"))
    var files []string

    for _, l := range lines {
        if len(l) > 0 {
            files = append(files, string(l))
        }
    }
    return files
}

func main() {
    // Input flags (CI agnostic)
    branch := flag.String("branch", "", "Branch name")
    base := flag.String("base", "", "Base commit SHA")
    commit := flag.String("commit", "", "Current commit SHA")
    repoURL := flag.String("repoURL", "", "Git Repo URL")

    flag.Parse()

    apiURL := os.Getenv("API_URL")
    if apiURL == "" {
        fmt.Println("ERROR: API_URL env var not set")
        os.Exit(1)
    }
    githubToken := os.Getenv("GITHUB_TOKEN")
    logCoverage := os.Getenv("LOG_COVERAGE_THRESHOLD")

    changed := getChangedFiles(*base, *commit)

    fmt.Println("Branch:", *branch)
    fmt.Println("Base commit:", *base)
    fmt.Println("Current commit:", *commit)
    fmt.Println("Changed files:", changed)	

    reqBody := Request{
        Branch:       *branch,
        BaseCommit:   *base,
        Commit:       *commit,
	RepoUrl:      *repoURL,
	GithubToken:  githubToken,
        ChangedFiles: changed,
	LogCoverage:  logCoverage,
    }

    body, _ := json.Marshal(reqBody)

    fmt.Println("JSON being sent:", string(body))
    req, _ := http.NewRequest("POST", apiURL, bytes.NewReader(body))
    req.Header.Set("Content-Type", "application/json")

    res, err := http.DefaultClient.Do(req)
    if err != nil {
        fmt.Println("API ERROR:", err)
        os.Exit(1)
    }

    var apiResp Response
    json.NewDecoder(res.Body).Decode(&apiResp)

    fmt.Println("API RESPONSE:", apiResp.Message)

    if apiResp.Status == "allow" {
    	os.Exit(0)
    } else {
    	fmt.Printf("❌ Coverage check failed! Scan ID: %d\n", apiResp.ScanID)
    	fmt.Printf("❌ Coverage failed! Fixing automatically...\n")

	fmt.Printf("pr_link=%s\n", "test.com")
    	// Call your API to fix the issue
    	// fixResp, err := callFixAPI(apiResp.ScanID) // implement this function
    	//if err != nil {
        //	fmt.Println("API ERROR while fixing:", err)
        //	os.Exit(1)
    	//}

    	// fixResp should contain the PR link
    	// fmt.Printf("✅ Fix applied! Review the PR here: %s\n", fixResp.PRLink)

    	os.Exit(1)
    }

}

