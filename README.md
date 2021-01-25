# customers-service

This app lists all customer in sqlite DB and tagging them as (Valid or Invalid) and the Country based on the customer's phone and pre defined regular expression validating in Java code 

This sample application uses:

- Java 11
- Spring boot
- Sqlite3
- JPA
- VueJs
- Swagger
- Maven
- Docker
- junit-jupiter for unit testing
- Shell scripting


Steps to run the application:

1- Clone the project `git clone git@github.com:hitham-ramzy/customers-service.git`

2- Make sure that Java 11 and maven are installed on your machine

3- Make sure that docker installed on your machine as well

3- Just run `./start.sh` to:

    - Package the application using maven.
    - Build the Docker Container and tag it.
    - Run the Docker Image.
    
4- check your `http://localhost:8080/` for Vue sample

5- check your `http://localhost:8080/swagger-ui/` for Swagger-ui

Hope you enjoy ;)

Missing points:

- Adding the missing regexp function to sqlite3
