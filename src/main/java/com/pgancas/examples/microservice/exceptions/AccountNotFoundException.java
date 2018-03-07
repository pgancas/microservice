package com.pgancas.examples.microservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for not found accounts
 * 
 * @author peter
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4040149150692530889L;

	public AccountNotFoundException(String string) {
		super("could not found account for '" + string + "'.");
	}
}
