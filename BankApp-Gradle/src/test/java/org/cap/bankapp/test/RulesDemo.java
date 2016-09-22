package org.cap.bankapp.test;

import static org.junit.Assert.*;

import org.cap.dto.Account;
import org.cap.dto.Address;
import org.cap.dto.Customer;
import org.cap.exception.InvalidInitialAmountException;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RulesDemo {
	
	private AcccountService acountService;
	
	@Before
	public void initMethod(){
		acountService=new AccountServiceImpl();
	}

	@Rule
	public ExpectedException thrown=ExpectedException.none();
	
	@Test
	public void test_addAccount_with_invalid_initial_Amount() throws InvalidInitialAmountException {
		
		thrown.expect(InvalidInitialAmountException.class);
		//thrown.expectMessage("Sorry! Invalid initial Amount.");
		thrown.expectMessage("initial Amount.");
		//thrown.expectMessage("Illegal Arg Exception.");
		
		Customer customer=new Customer();
		customer.setCustName("Tom");
		customer.setCustAddress(new Address());
		
		acountService.addAccount(customer, 300);
		
	}

}
