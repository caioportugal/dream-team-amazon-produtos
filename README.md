# Product api 

## Running project local

Install docker and docker-compose 

Create a .env file with the information below
```
DATABASE_USER=products-api
DATABASE_PASSWORD=senhadanasa
DATABASE_PORT=5432
API_PORT=8082
```

after this start application run the command docker-compose up -d

## Dependency

The project use:

- JDK 11.0.1
- Spring Boot 2.4.3
    - JPA
    - Web
- Maven
- Lombok
- Postgres
- Swagger2 (SpringFox)

## Structure

The general directory structure is:

```
├── src
    └── main
        └── java
            └── configuration
            └── controller
            └── dto
            └── exception
            └── model
            └── repository
            └── service

```

