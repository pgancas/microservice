package com.thecocktail.examples.microservice.service.impl;

import org.springframework.stereotype.Service;

import com.thecocktail.examples.microservice.entity.Account;
import com.thecocktail.examples.microservice.entity.TransferAmount;
import com.thecocktail.examples.microservice.service.TransferToAccountService;

/**
 * Simple implementation of TransferToAccountService
 * @author peter
 *
 */
@Service
public class SimpleTransferToAccountServiceImpl implements TransferToAccountService {

	@Override
	public Account transfer(TransferAmount transfer, Account account) {
		account.setAmount(account.getAmount().add(transfer.getAmount()));
		return account;
	}
}
