package com.pgancas.examples.microservice.service.impl;

import org.springframework.stereotype.Service;

import com.pgancas.examples.microservice.entity.Account;
import com.pgancas.examples.microservice.entity.TransferAmount;
import com.pgancas.examples.microservice.service.TransferToAccountService;

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
