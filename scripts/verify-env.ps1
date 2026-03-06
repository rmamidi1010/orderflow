# Verify development environment for Java microservices learning plan
# Run from repo root: .\scripts\verify-env.ps1

$allOk = $true

function Test-Command($name, $arg, $expectPattern) {
    try {
        $out = & $name $arg 2>&1 | Out-String
        if ($LASTEXITCODE -ne 0 -and $null -ne $LASTEXITCODE) {
            Write-Host "FAIL: $name - exit code $LASTEXITCODE" -ForegroundColor Red
            return $false
        }
        if ($expectPattern -and $out -notmatch $expectPattern) {
            Write-Host "FAIL: $name - output did not match '$expectPattern'" -ForegroundColor Red
            return $false
        }
        Write-Host "OK: $name" -ForegroundColor Green
        return $true
    } catch {
        Write-Host "FAIL: $name - not found or error: $_" -ForegroundColor Red
        return $false
    }
}

Write-Host "`n--- Java Microservices Environment Check ---`n" -ForegroundColor Cyan

# JDK 21+ (java writes version to stderr; use cmd to avoid PowerShell stderr handling)
$javaVersionRaw = cmd /c "java -version 2>&1"
$javaVersion = if ($javaVersionRaw -is [array]) { $javaVersionRaw -join " " } else { [string]$javaVersionRaw }
if ($javaVersion -match "version\s+""?(\d+)") {
    $major = [int]$Matches[1]
    if ($major -ge 21) {
        Write-Host "OK: java (JDK $major)" -ForegroundColor Green
    } else {
        Write-Host "FAIL: java - JDK 21+ required, found $major" -ForegroundColor Red
        $allOk = $false
    }
} else {
    Write-Host "FAIL: java - not found or could not parse version" -ForegroundColor Red
    $allOk = $false
}

# Maven (mvn may write warnings to stderr; use cmd to avoid false failures)
$mvnOut = cmd /c "mvn -version 2>&1"
if ($mvnOut -match "Maven" -and $LASTEXITCODE -eq 0) {
    Write-Host "OK: mvn" -ForegroundColor Green
} elseif ($mvnOut -match "Maven") {
    Write-Host "OK: mvn" -ForegroundColor Green
} else {
    Write-Host "FAIL: mvn - not found" -ForegroundColor Red
    $allOk = $false
}

# Docker
if (-not (Test-Command "docker" "--version" "Docker")) { $allOk = $false }

# Git
if (-not (Test-Command "git" "--version" "git version")) { $allOk = $false }

Write-Host ""
if ($allOk) {
    Write-Host "All required tools are installed. You can proceed with Stage 1." -ForegroundColor Green
    exit 0
} else {
    Write-Host "Some tools are missing. See SETUP.md for installation instructions." -ForegroundColor Yellow
    exit 1
}
