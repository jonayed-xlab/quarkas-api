# Quarkus-api

This project uses Quarkus, to build a rest API.

## Required Tools & Technology
- JDK 17
- Docker 24.0.6
- Quarkus 3.5

## Required Dependencies
- RESTEasy Reactive jackson
- JPAStreamer
- SmallRye OenAPI
- JDBC Driver - MySQL
- Hibernate ORM With Panache

## Install Database docker container
```shell script
docker run --platform linux/amd64 -d --publish 3306:3306 --name sakila restsql/mysql-sakila
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-api-1.0.0-SNAPSHOT-runner`

## Endpoints
```
- GET 
localhost:8080/hello
localhost:8080/film/{filmId}
localhost:8080/pagedFilms/{page}/{minLength}
localhost:8080/actors/{startWith}/{minLength}
````
To use these endpoints, replace the placeholders with appropriate values.
