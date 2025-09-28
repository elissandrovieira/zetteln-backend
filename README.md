# Zetteln Backend

Zetteln is a lightweight and efficient Markdown reader backend designed to power your note-taking applications. It provides a robust API to fetch, manage, and serve Markdown files seamlessly.

---

## Features

- Serve Markdown files as JSON.
- Support for multiple users and vaults.
- Easy integration with frontend apps.
- Fast and lightweight architecture.
- RESTful API endpoints for CRUD operations on notes and vaults.

## Technologies Used

- Java / Spring Boot – Backend framework
- JPA / Hibernate – Database ORM
- PostgreSQL – Relational database
- Lombok – Boilerplate code reduction
- Maven – Dependency management

## Installation

1. Clone the repository:
```shell
git clone https://github.com/yourusername/zetteln-backend.git
cd zetteln-backend
```
2. Set up your PostgreSQL database and update application.properties with your credentials.
3. Build and run the application:
```shell
mvn clean install
mvn spring-boot:run
```
4. Access the API at http://localhost:8080.

## API Endpoints

- GET /users – List all users
- GET /users/{id} – Get a single user
- POST /users – Create a new user
- PUT /users/{id} – Update an existing user
- DELETE /users/{id} – Delete a user

*(Similar endpoints exist for managing vaults and users.)*

## Next Steps

- Add DTOs and mappers for Vaults and Notes.
- Implement ResponseEntity for Vault and Notes endpoints.
- Add authentication for users making requests.
- Add input validation and error handling.
- Implement logging for easier debugging and monitoring.
- Write unit and integration tests to ensure reliability.
- Add API documentation using Swagger for easier frontend integration.

---
Thank you for checking out Zetteln Backend.
