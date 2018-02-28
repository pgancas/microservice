package com.thecocktail.examples.microservice.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model to transfer amounts to accounts
 * 
 * @author peter
 *
 */
public class TransferAmount {

	/**
	 * Amount to transfer
	 */
	@JsonProperty
	private BigDecimal amount;
	
	public TransferAmount() {
		super();
	}
	
	public TransferAmount(BigDecimal amount) {
		super();
		this.amount = amount;
	}


	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
