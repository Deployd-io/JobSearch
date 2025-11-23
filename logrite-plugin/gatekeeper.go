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
    ChangedFiles []string `json:"changed_files"`
}

type Response struct {
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

    flag.Parse()

    apiURL := os.Getenv("API_URL")
    if apiURL == "" {
        fmt.Println("ERROR: API_URL env var not set")
        os.Exit(1)
    }

    changed := getChangedFiles(*base, *commit)

    reqBody := Request{
        Branch:       *branch,
        BaseCommit:   *base,
        Commit:       *commit,
        ChangedFiles: changed,
    }

    body, _ := json.Marshal(reqBody)

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
        os.Exit(1)
    }
}

