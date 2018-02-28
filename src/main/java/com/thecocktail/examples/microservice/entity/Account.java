package com.thecocktail.examples.microservice.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Persistence model for accounts
 * 
 * @author peter
 *
 */
@Entity
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1609536486678351L;

	/**
	 * Id for this account
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Name given to this account
	 */
	@Column
	private String name;

	/**
	 * Amount of this account
	 */
	@Column
	private BigDecimal amount;

	/**
	 * Empty constructor initialize amount to 0
	 */
	public Account() {
		super();
		initialize();
	}

	public Account(String name) {
		super();
		initialize();
		this.name = name;
	}

	private void initialize() {
		this.amount = new BigDecimal("0");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
