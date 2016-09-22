package org.cap.bankapp.test;

import static org.junit.Assert.*;

import org.cap.dao.AccountDao;
import org.cap.dto.Account;
import org.cap.dto.Address;
import org.cap.dto.Customer;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BankAppTestCaseDependencies {
	@Mock
	private AccountDao accountDao;
	
	private AcccountService accountService;
	
	@Before
	public void initMethod(){
		
		MockitoAnnotations.initMocks(this);
		accountService=new AccountServiceImpl(accountDao);
	}

	@Test
	@Category({GoodTestCategory.class})
	public void test_findAccountById_with_Mockito() {
	Account account=new Account();
	Customer customer=new Customer();
	customer.setCustName("Jerry");
	customer.setCustAddress(new Address());
		
	account.setAccountNo(12);
	account.setCustomer(customer);
	account.setAmount(1300);
	
		//Declaration
		Mockito.when(accountDao.findAccountById(12)).thenReturn(account);
		
		//Actual Bussiness logic
		Account account2=accountService.findAccountById(12);
		
		//Verification
		Mockito.verify(accountDao).findAccountById(12);
		
		
		assertEquals(1300, account2.getAmount(),0.0);
	}

	@Test
	@Category({BadTestCategory.class})
	public void test_deposit_method_with_Mockito(){
		Account account=new Account();
		Customer customer=new Customer();
		customer.setCustName("Tom");
		customer.setCustAddress(new Address());
			
		account.setAccountNo(1001);
		account.setCustomer(customer);
		account.setAmount(5000);
		
			//Declaration
			Mockito.when(accountDao.findAccountById(1001)).thenReturn(account);
			
			//Actual Bussiness logic
			Account account2=accountService.deposit(1001, 500);
			
			//Verification
			Mockito.verify(accountDao).findAccountById(1001);
			
			assertEquals(5500, account2.getAmount(),0.0);
			
	}
}
