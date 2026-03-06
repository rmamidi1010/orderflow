# Orderflow

A small Java microservices system built as a learning project: order management, event-driven flows (Kafka), observability, API gateway, caching, and Oracle integration. Follows a staged roadmap from Java fundamentals through Spring Boot, Kafka, Docker, and Azure.

## Tools

- **JDK 21+**, **Maven**, **Docker**, **Git**

See [SETUP.md](SETUP.md) for install and verification. Run:

```powershell
.\scripts\verify-env.ps1
```

## Roadmap (high level)

1. Java fundamentals + Maven + JUnit 5  
2. Spring Boot REST + H2  
3. Split into services (e.g. order-service, inventory-service)  
4. Kafka event flow  
5. Logging, metrics, tracing  
6. Service discovery + API gateway  
7. Redis caching  
8. Oracle + migrations  
9. Docker + Azure  
10. Security, resilience, CI/CD  

## Repo layout

- `scripts/` – environment and utility scripts  
- `SETUP.md` – dev environment setup and verification  

Services and app code will be added as the roadmap progresses.
