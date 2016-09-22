package org.cap.bankapp.test;

import java.util.Arrays;
import java.util.List;

import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTestCase {
	
	private AcccountService acccountService=new AccountServiceImpl();

	public int input1;
	public int input2;
	public int output;
	
	public ParameterizedTestCase(int input1, int input2, int output) {
		this.input1 = input1;
		this.input2 = input2;
		this.output = output;
	}
	
	@Parameters
	public static List<Object[]> myParameters(){
		return Arrays.asList(new Object[][]{
			{1,2,3},
			{-1,-1,-2},
			{0,1,1},
			{0,0,0},
			{-3,1,-2}
		});
	}
	
	@Test
	public void testAddNumbers(){
		Assert.assertEquals(output, acccountService.addNumbers(input1, input2));
	}
	
}
