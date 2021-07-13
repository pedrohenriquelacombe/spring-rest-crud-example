# Spring Rest API Template
This project is an implementation of a basic CRUD using RESTful principles.

## About
The main goal of this project is to serve as a **basis to start the development of a new REST API**.

## Technologies
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Validation](https://beanvalidation.org/)
- [Lombok](https://projectlombok.org/)
- [ModelMapper](http://modelmapper.org/)
- [H2 Database](https://www.h2database.com/html/quickstart.html)

## Features
 - DTO (Data Transfer Object) principles
 - Automaticaly converter DTO to Entity
 - Custom Exception Handler messages

## Built With
- [Spring Initializr](https://start.spring.io/)
- [Maven](https://maven.apache.org/index.html)

## How can i test my endpoints?
First, open your preference code editor and run the following code below:
```
mvn clean install
```

After the maven downloaded all dependencies, run the SpringRestTemplateApplication.class.

For tests cases, you can check the API endpoints with Postman.

- [Postman Collection](https://www.getpostman.com/collections/f4ee24c26c1c6eea14de)