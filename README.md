<p align="left"> <a href="https://www.java.com" target="_blank" rel="noreferrer"> 
<img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="70" height="50"/>
</a> <a href="https://www.postgresql.org" target="_blank" rel="noreferrer"> 
<img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original-wordmark.svg" alt="postgresql" width="70" height="50"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer">
<img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="70" height="50"/> </a> </p>

# HealthHelper Appointment Schedule

## Stack

This application use:

- Java 17
- Spring Boot 3.1.4
- Spring Security 6
- JWT
- Postgres
- JUnit


## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven](https://maven.apache.org/download.cgi)
- [Docker](https://www.docker.com/products/docker-desktop/)


## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the [HealthHelperCustomerApplication](src%2Fmain%2Fjava%2Fbr%2Fcom%2Fhealthhelper%2Fcustomer%2FHealthHelperCustomerApplication.java) class from your IDE.

You needed a postgres to execute this application.

run docker command to create new instance

``
docker run --name hh_database -e POSTGRES_PASSWORD=hhpassword -p 5432:5432 -d postgres
``

and execute this script: [0.0.1-CREATE_DATABASE](src%2Fmain%2Fresources%2Fscripts%2F0.0.1-CREATE_DATABASE.sql)