package org.cap.bankapp.test;

import static org.junit.Assert.*;

import org.cap.dto.Address;
import org.cap.dto.Customer;
import org.cap.exception.InvalidInitialAmountException;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BankAppTestCases {
	
	private AcccountService accountService;
	
	@Before
	public void initMethod(){
		System.out.println("Before Method");
		accountService=new AccountServiceImpl();
		
	}

	@Test
	@Category({GoodTestCategory.class})
	public void testCaseAddNumbers(){
		System.out.println("testCaseAddNumbers");
		assertEquals(10, accountService.addNumbers(8, 2));
	}

	@Category({BadTestCategory.class})
	@Test(expected=IllegalArgumentException.class)
	public void testAddAccount_with_null_customer() throws InvalidInitialAmountException{
		Customer customer=null;
		double amount=1000;
		
		accountService.addAccount(customer, amount);
	}
	
	@Category({GoodTestCategory.class})
	@Test(expected=IllegalArgumentException.class)
	public void testAddAccount_with_invalid_initialAmount() throws InvalidInitialAmountException{
		Customer customer=new Customer();
		customer.setCustName("Tom");
		customer.setCustAddress(new Address());
		
		double amount=300.00;
		
		accountService.addAccount(customer, amount);
		
	}
	
	@Category({BadTestCategory.class})
	@Ignore
	@Test(timeout=500)
	public void testMyLoop(){
		long sum=0;
		for(long i=0;i<1000000l;i++)
			sum+=i;
	}
	
	
	
	
	
	
	
	
	
	
	
	@BeforeClass
	public static void setUpMethod(){
		System.out.println("Before Class Method");
	}
	
	
	
	
	
	@After
	public void destroyMethod(){
		System.out.println("After Method");
		accountService=new AccountServiceImpl();
		
	}
	
	@AfterClass
	public static void tearDownMethod(){
		System.out.println("After Class Method");
	}
}
