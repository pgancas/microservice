package com.pgancas.examples.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Simple example of boot rest services Exposes accounts (list, get, create,
 * delete) and let add ammounts for each account
 * 
 * @author peter
 *
 */
@SpringBootApplication
@ComponentScan({"com.pgancas.examples.microservice"})
public class MicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);
	}
}
