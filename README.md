# microservice
Simple example of rest service with spring boot

Requires Java 8, Maven, Docker
  
To get jar use:
  mvn clean install
and look at ./target/docker

To run:
 with maven:
 	mvn spring-boot:run
 with docker:
    docker-compose up -d

It is a simple boot spring application with a rest controller to manage accounts.
See controller tests to check usage.
