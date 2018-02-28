package com.thecocktail.examples.microservice.service;

import com.thecocktail.examples.microservice.entity.Account;
import com.thecocktail.examples.microservice.entity.TransferAmount;

/**
 * Service to transfer amounts to accounts
 * @author peter
 *
 */
public interface TransferToAccountService {
	/**
	 * Add to account's amount the transfer's account
	 * @param transfer amount to be transfered
	 * @param account account to transfer to
	 * @return the account with the amount transfered
	 */
	public Account transfer(TransferAmount transfer, Account account);
}
