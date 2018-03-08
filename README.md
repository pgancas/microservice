# microservice
Simple example of rest service with spring boot.

It is a simple boot spring application with a rest controller to manage accounts.

See controller tests to check usage.

It has a simple configuration to run with docker too. 

## Requires 

- Java 8


- Maven


- Docker

### To get jar use:

  `mvn clean install`

and look at ./target/docker

### To run:

 with maven:
 	`mvn spring-boot:run`

 with docker:
​	`docker-compose up -d`

###Check health

 Actuators endpoints like /metrics, /info, /loggers... 
 See https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready-endpoints	

### Service info

By swagger2, at runtime check endpoint /swagger-ui.html

