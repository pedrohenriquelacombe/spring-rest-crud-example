# Spring REST API CRUD Example

This project is a basic implementation of a CRUD API using RESTful principles and SOLID design patterns.

## About

The main goal of this project is to serve as a **starting point for developing new RESTful APIs** with Spring Boot. It
demonstrates how to structure a clean API using DTOs, exception handling, and automatic mapping.

## Technologies

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Jakarta Bean Validation](https://beanvalidation.org/)
- [Lombok](https://projectlombok.org/)
- [ModelMapper](http://modelmapper.org/)
- [H2 Database (for tests)](https://www.h2database.com/html/quickstart.html)
- [Docker](https://docs.docker.com/get-started/)
- [PostgreSQL](https://www.postgresql.org/)

## Features

- DTO (Data Transfer Object) structure
- Automatic mapping between DTO and Entity
- Custom exception handling with standardized error messages
- Separation of concerns with service and repository layers

## Built With

- [Spring Initializr](https://start.spring.io/)
- [Maven](https://maven.apache.org/)

## Getting Started

### Run Manually

1. Install dependencies:

```bash
  mvn clean install
```

2. Start the PostgreSQL container:

```bash
  docker compose up db -d
```

3. Run the application:

```bash
   mvn spring-boot:run
```

### Run with Docker

Start the full application stack with Docker Compose:

```bash
   docker compose up db -d
```

## API Testing

You can test the API endpoints using [Bruno API Client](https://www.usebruno.com/).

> A folder named `bruno/` exists in the root of this project and contains all predefined request collections for testing
> the endpoints.

### How to use:

1. Install Bruno (if you haven't yet):  
   [https://www.usebruno.com/downloads](https://www.usebruno.com/downloads)

2. Open the project in Bruno:
    - Open Bruno
    - Click **Open Collection Folder**
    - Select the `bruno/` folder located in the root of this project

3. Run the requests:
    - The requests are organized by resource
    - You can test all CRUD operations directly from the interface

Alternatively, you can use Postman, curl, or any other HTTP client to interact with the API.
