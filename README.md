# Item Management

## Table of Contents
* [Technologies Used](#technologies-used)
* [Features](#features)
* [Screenshots](#screenshots)
* [Project Structure](#project-structure)
* [Setup](#setup)
* [Project Status](#project-status)
* [Contact](#contact)
* [Sources](#sources)

## Technologies Used
- Java - version 17.0.3.1
- Spring Boot (with Spring Security, Spring Web, Spring Data JPA, Spring Test) - version 2.7.1
- MySQL - version 8.0.29
- jjwt - version 4.0.0
- Maven - version 3.8.6
- Lombok - version 1.18.24


## Features
List the ready features here:
- User can signup new account (registration), or login with username & password.
- The user can create his own items and display a list of them


## Screenshots
![image](https://user-images.githubusercontent.com/93727414/177596125-0f225ee3-a571-443b-83db-5946fbb0515e.png)
![image](https://user-images.githubusercontent.com/93727414/177724543-f6e3687b-97d5-4f25-a47c-00e887b36340.png)
![image](https://user-images.githubusercontent.com/93727414/177724620-00e5ca15-c25b-4304-87cb-624cb97cea13.png)
![image](https://user-images.githubusercontent.com/93727414/177724669-5b08d0df-ffce-47ff-9c8e-cb532ec097b0.png)

## Project Structure
![image](https://user-images.githubusercontent.com/93727414/177725103-504b810b-ba01-457c-bcab-97582f53aa4d.png)


## Setup
### Building the application
- Clone [this repository](https://github.com/jakubknap/Item-Management.git) to your IDE (https://github.com/jakubknap/Item-Management.git)
- The project uses [Maven](https://maven.apache.org/) as a build tool. It already contains
`.mvn` wrapper script, so there's no need to install maven.
- Manually create the database at: localhost:3306
 ```bash
  CREATE DATABASE test
```
- To build and run the project execute the following command:
```bash
  mvn spring-boot:run
```
- Use [Postman](https://www.postman.com/) for querying

## These are APIs that are available
### Default login: test, Default password: test
![image](https://user-images.githubusercontent.com/93727414/177601092-93a1159e-9d2c-43f1-b596-8bb0cc9b3ade.png)



## Project Status
I am still working on the project.


## Contact
Created by [Jakub Knap](https://www.linkedin.com/in/jakub-knap/) - feel free to contact me!

## Sources
### This app is inspired by:
- [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#legal)
- [Hibernate ORM Documentation](https://hibernate.org/orm/documentation/6.1/)
- [Spring Boot and Spring Security with JWT by Amigoscode](https://www.youtube.com/watch?v=VVn9OG9nfH0)
- [Integration tests of the Json Web Token secured application by Mateusz Dąbrowski](https://www.youtube.com/watch?v=Lk5mzbU5jrg&ab_channel=MateuszD%C4%85browski)


