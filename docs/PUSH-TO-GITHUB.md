# Push Orderflow to GitHub

The repo is initialized locally. To push to GitHub:

## Option A: Create repo on GitHub, then push (no CLI)

1. **Create a new repository on GitHub**
   - Go to [github.com/new](https://github.com/new)
   - Repository name: `orderflow` (or any name you prefer)
   - Visibility: Public or Private
   - Do **not** add a README, .gitignore, or license (we already have them)

2. **Add the remote and push** (run in this project folder):

   ```powershell
   cd c:\learning\cursor\java

   git remote add origin https://github.com/YOUR_USERNAME/orderflow.git
   git branch -M main
   git push -u origin main
   ```

   Replace `YOUR_USERNAME` with your GitHub username. If you used a different repo name, use that instead of `orderflow`.

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
