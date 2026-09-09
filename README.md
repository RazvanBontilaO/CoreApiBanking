# Banking Core API

A professional, portfolio-ready Spring Boot banking application featuring robust architecture, enterprise-grade
security, automated transaction auditing, and containerized deployment.

## Features

* **Core Banking Operations**: Account creation, secure deposits, withdrawals, and money transfers.
* **Concurrency & Safety**: Implements **Optimistic Locking** to handle concurrent balance updates safely.
* **Transaction Audit Trail**: Uses independent transaction propagation (`REQUIRES_NEW`) to ensure failed transactions (
  e.g., due to insufficient funds) are permanently logged into an audit trail.
* **Security**: Stateless authentication powered by **Spring Security** and **JWT (JSON Web Tokens)**.
* **Interactive Documentation**: Fully integrated **Swagger** interface with JWT Bearer token authorization support.
* **Automated Testing**: Integration tests built with **JUnit 5** and **Testcontainers** (spinning up a real PostgreSQL
  container during test execution).
* **Containerization**: Fully dockerized using **Docker** and **Docker Compose** for instant multi-service execution.

---

## 🛠️ Tech Stack

* **Backend**: Java 21, Spring Boot, Spring Security, Spring Data JPA (Hibernate)
* **Database**: PostgreSQL 15
* **Build Tool**: Maven
* **Documentation**: Springdoc OpenAPI (Swagger UI)
* **Testing**: JUnit 5, Testcontainers, AssertJ
* **DevOps**: Docker, Docker Compose

---

## ⚙️ Getting Started with Docker

Make sure you have [Docker Desktop](https://www.docker.com/) installed and running on your system.

1. **Clone the repository**:
   ```bash
   git clone [https://github.com/your-username/banking-core-api.git](https://github.com/your-username/banking-core-api.git)
   cd banking-core-api

2. **Clone the repository**:
    ```bash
    docker compose up --build
This command will build the Spring Boot application jar inside a Maven container, spin up the PostgreSQL database, and launch both services together.

3. **Acces the API Documentation**:
    ```bash
    http://localhost:8080/swagger-ui/index.html
   
## API Endpoints Overview
POST - /api/v1/auth/register - Register a new user

POST /api/v1/auth/login - Authenticate and receive a JWT token

POST /api/v1/accounts - Create a bank account (Authenticated)

POST /api/v1/accounts/withdraw - Withdraw funds

POST /api/v1/accounts/transfer - Transfer money between accounts

## Running Tests
    mvn clean test

