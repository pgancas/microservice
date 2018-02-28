package com.thecocktail.examples.microservice.service.impl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.thecocktail.examples.microservice.entity.Account;
import com.thecocktail.examples.microservice.entity.TransferAmount;
import com.thecocktail.examples.microservice.service.TransferToAccountService;


@RunWith(SpringRunner.class)
public class SimpleTransferToAccountServiceImplTest {

	@TestConfiguration
	static class SimpleTransferToAccountServiceImplTestContextConfiguration {
		@Bean
		public TransferToAccountService transferToAccountService() {
			return new SimpleTransferToAccountServiceImpl();
		}
	}
	
	@Autowired
    private TransferToAccountService transferToAccountService;
 
	@Test
	public void testInitialAdd() {
		//initial account, with 0 amount
		Account account = new Account("test");
		
		//a transfer of 10 units
		TransferAmount transfer = new TransferAmount(new BigDecimal(10));
		
		Account transfered = transferToAccountService.transfer(transfer, account);
		
		Assert.assertEquals(new BigDecimal(10), transfered.getAmount());
	}
	
	@Test
	public void testInitialSubstract() {
		//initial account, with 0 amount
		Account account = new Account("test");
		
		//a transfer of 10 units
		TransferAmount transfer = new TransferAmount(new BigDecimal(-10));
		
		Account transfered = transferToAccountService.transfer(transfer, account);
		
		Assert.assertEquals(new BigDecimal(-10), transfered.getAmount());
	}
	
	@Test
	public void testModifiedAdd() {
		//initial account, with 10 amount
		Account account = new Account("test");
		account.setAmount(new BigDecimal(10));
		
		//a transfer of 10 units
		TransferAmount transfer = new TransferAmount(new BigDecimal(10));
		
		Account transfered = transferToAccountService.transfer(transfer, account);
		
		Assert.assertEquals(new BigDecimal(20), transfered.getAmount());
	}
	
	@Test
	public void testModifiedSubstract() {
		//initial account, with 10 amount
		Account account = new Account("test");
		account.setAmount(new BigDecimal(10));
		
		//a transfer of 10 units
		TransferAmount transfer = new TransferAmount(new BigDecimal(-10));
		
		Account transfered = transferToAccountService.transfer(transfer, account);
		
		Assert.assertEquals(new BigDecimal(0), transfered.getAmount());
	}
	

}
