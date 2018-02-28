package com.thecocktail.examples.microservice.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.thecocktail.examples.microservice.entity.Account;
import com.thecocktail.examples.microservice.entity.TransferAmount;
import com.thecocktail.examples.microservice.exceptions.AccountNotFoundException;
import com.thecocktail.examples.microservice.repository.AccountRepository;

/**
 * Controller to manage accounts
 * 
 * @author peter
 *
 */
@RestController
public class AccountResource {

	/**
	 * Persistence for accounts
	 */
	@Autowired
	private AccountRepository accountRepository;

	/**
	 * List all accounts persisted
	 * 
	 * @return List of accounts retrieved
	 */
	@GetMapping("/accounts")
	public List<Account> retrieveAllAccounts() {
		return accountRepository.findAll();
	}

	/**
	 * Get data for an existing account
	 * 
	 * @param id
	 *            Account to get
	 * @return Account details
	 * @throws AccountNotFoundException
	 *             if no account found for that id
	 */
	@GetMapping("/accounts/{id}")
	public Account retrieveAccount(@PathVariable long id) throws AccountNotFoundException {
		Account account = accountRepository.findOne(id);

		if (account == null)
			throw new AccountNotFoundException("id-" + id);

		return account;
	}

	/**
	 * Delete an account
	 * 
	 * @param id
	 *            Account's id to delete
	 */
	@DeleteMapping("/accounts/{id}")
	public void deleteAccount(@PathVariable long id) {
		accountRepository.delete(id);
	}

	/**
	 * Create an account with 0 amount
	 * 
	 * @param account
	 *            Account's name to create
	 * @return Created if ok
	 */
	@PostMapping("/accounts")
	public ResponseEntity<Object> createAccount(@RequestBody Account account) {
		Account savedAccount = accountRepository.save(account);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedAccount.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	/**
	 * Add an amount to an existing account
	 * 
	 * @param transfer
	 *            ammount to transfer
	 * @param id
	 *            Account's id to transfer the amount
	 * @return No content
	 */
	@PutMapping("/accounts/{id}")
	public ResponseEntity<Object> updateAccount(@RequestBody TransferAmount transfer, @PathVariable long id) {

		Account accountRetrieved = accountRepository.findOne(id);

		if (accountRetrieved == null)
			return ResponseEntity.notFound().build();

		accountRetrieved.setAmount(accountRetrieved.getAmount().add(transfer.getAmount()));

		accountRepository.save(accountRetrieved);

		return ResponseEntity.noContent().build();
	}
}
