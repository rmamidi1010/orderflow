# Push Orderflow to GitHub

The repo is initialized locally. To push to GitHub:

## Option A: Create repo on GitHub, then push (no CLI)

1. **Create a new repository on GitHub**
   - Go to [github.com/new](https://github.com/new)
   - Repository name: `orderflow` (or any name you prefer)
   - Visibility: Public or Private
   - Do **not** add a README, .gitignore, or license (we already have them)

2. **Add the remote and push** (run in this project folder):

   Replace **your-github-username** below with your actual GitHub username (e.g. `jane-doe`), then run:

   ```powershell
   cd c:\learning\cursor\java

   git remote add origin https://github.com/your-github-username/orderflow.git
   git branch -M main
   git push -u origin main
   ```

   If you already added `origin` with the wrong URL, fix it first:
   ```powershell
   git remote set-url origin https://github.com/your-github-username/orderflow.git
   ```

3. **If GitHub asks for auth**: use a [Personal Access Token](https://github.com/settings/tokens) as the password when prompted, or set up [Git Credential Manager](https://github.com/GitCredentialManager/git-credential-manager).

## Option B: Use GitHub CLI (if you install it)

1. Install: `winget install GitHub.cli`
2. Log in: `gh auth login`
3. Create repo and push:

   ```powershell
   cd c:\learning\cursor\java
   gh repo create orderflow --public --source=. --remote=origin --push
   ```

Use `--private` instead of `--public` if you want a private repo.

## Optional: strip "Made-with: Cursor" from commits

To keep commit messages free of that trailer, use the project’s hook:

```powershell
copy scripts\githooks\commit-msg .git\hooks\commit-msg
```

Or use the githooks folder as your hooks path: `git config core.hooksPath scripts/githooks`
