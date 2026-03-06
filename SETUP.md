# Java Microservices – Development Environment Setup

This document describes the tools required for the [Java Microservices Learning Roadmap](.cursor/plans/java-microservices-learning-roadmap_922c515f.plan.md) and how to verify your environment.

## Required Tools

| Tool | Purpose | Minimum / Recommended |
|------|---------|------------------------|
| **JDK** | Java runtime and compiler | JDK 21+ (LTS) |
| **Maven** or **Gradle** | Build and dependency management | Maven 3.8+ or Gradle 8+ |
| **Docker** | Local Kafka, Redis, DBs, and deployment | Docker Desktop or Engine |
| **Git** | Version control | Any recent version |

## Verify Your Environment

Run the verification script from the project root:

```powershell
.\scripts\verify-env.ps1
```

Or check manually:

```powershell
java -version    # Expect: openjdk version "21" or higher
mvn -version     # Expect: Apache Maven 3.x (if using Maven)
docker --version # Expect: Docker version 20.x or higher
git --version    # Expect: git version 2.x
```

## Installation (if something is missing)

### Windows

- **JDK 21+**: [Eclipse Temurin](https://adoptium.net/) or [Oracle JDK](https://www.oracle.com/java/technologies/downloads/).  
  Set `JAVA_HOME` to the JDK install directory (e.g. `C:\Program Files\Eclipse Adoptium\jdk-21.x.x`).
- **Maven**: [Apache Maven](https://maven.apache.org/download.cgi) – unpack and add `bin` to `PATH`. Or use **winget**: `winget install Apache.Maven`
- **Docker**: [Docker Desktop for Windows](https://docs.docker.com/desktop/install/windows-install/)
- **Git**: [Git for Windows](https://git-scm.com/download/win) or **winget**: `winget install Git.Git`

### Optional: Gradle

If you prefer Gradle over Maven:

- [Gradle install guide](https://gradle.org/install/)  
- Or **winget**: `winget install Gradle.Gradle`

## Next Steps

After the environment is verified:

1. **Stage 1** – Create a simple Java console app with Maven/Gradle, config loading, and JUnit 5 tests.
2. **Stage 2** – Use [Spring Initializr](https://start.spring.io/) to bootstrap a Spring Boot REST API.

See the learning roadmap plan for the full sequence.
