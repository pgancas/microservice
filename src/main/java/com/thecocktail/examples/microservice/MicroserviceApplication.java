package com.thecocktail.examples.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Simple example of boot rest services Exposes accounts (list, get, create,
 * delete) and let add ammounts for each account
 * 
 * @author peter
 *
 */
@SpringBootApplication
public class MicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);
	}
}
