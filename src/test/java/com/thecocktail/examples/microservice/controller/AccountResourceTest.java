package com.thecocktail.examples.microservice.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.thecocktail.examples.microservice.entity.Account;
import com.thecocktail.examples.microservice.repository.AccountRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountResource.class)
public class AccountResourceTest {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Autowired
	private MockMvc mvc;

	@MockBean
	private AccountRepository accountRepository;

	@Test
	public void testRetrieveAllAccountsEmpty() throws Exception {
		given(this.accountRepository.findAll()).willReturn(new ArrayList<Account>());
		this.mvc.perform(get("/accounts").accept(contentType)).andExpect(status().isOk())
				.andExpect(content().string("[]"));
	}

	@Test
	public void testRetrieveAllAccountsNotEmpty() throws Exception {
		List<Account> listAccounts = new ArrayList<Account>();
		listAccounts.add(new Account("test_account"));
		given(this.accountRepository.findAll()).willReturn(listAccounts);
		this.mvc.perform(get("/accounts").accept(contentType)).andExpect(status().isOk())
				.andExpect(content().string("[{\"id\":null,\"name\":\"test_account\",\"amount\":0}]"));
	}

	@Test
	public void testRetrieveAccountsExists() throws Exception {
		Account account = new Account("test_account");
		given(this.accountRepository.findOne(Mockito.anyLong())).willReturn(account);
		this.mvc.perform(get("/accounts/1").accept(contentType)).andExpect(status().isOk())
				.andExpect(content().string("{\"id\":null,\"name\":\"test_account\",\"amount\":0}"));
	}

	@Test
	public void testRetrieveAccountsNotExists() throws Exception {
		given(this.accountRepository.findOne(Mockito.anyLong())).willReturn(null);
		this.mvc.perform(get("/accounts/1").accept(contentType)).andExpect(status().isNotFound());
	}

	@Test
	public void testDeleteAccountAccountExists() throws Exception {
		this.mvc.perform(delete("/accounts/1").accept(contentType)).andExpect(status().isOk());
	}

	@Test
	public void testCreateAccount() throws Exception {
		String account = "{\"name\": \"posted_account\"}";
		given(this.accountRepository.save(Mockito.any(Account.class))).willReturn(new Account());
		this.mvc.perform(post("/accounts").contentType(contentType).accept(contentType).content(account))
				.andExpect(status().isCreated());
	}

	@Test
	public void testTransferToAccount() throws Exception {
		Account account = new Account("test_account");
		given(this.accountRepository.findOne(Mockito.anyLong())).willReturn(account);

		given(this.accountRepository.save(Mockito.any(Account.class))).willReturn(new Account());
		String transfer = "{\"amount\": 10}";
		this.mvc.perform(put("/accounts/1").contentType(contentType).accept(contentType).content(transfer))
				.andExpect(status().isNoContent());
	}
}
