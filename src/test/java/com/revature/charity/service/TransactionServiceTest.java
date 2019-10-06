package com.revature.charity.service;

import static org.junit.Assert.assertEquals; 


import org.junit.Test;

import com.revature.charity.model.Transaction;
import com.revature.charity.util.Logger;

public class TransactionServiceTest {
	@Test
	public void transactionServiceTest()
	{
		
		TransactionService service = new TransactionServiceImpl();
		Transaction transactionObj = new Transaction();
		transactionObj.setDonorId(79);
		transactionObj.setfundRequestId(158);
		transactionObj.setAmount(500D);
		System.out.println(transactionObj);
		Boolean isStatus = service.transaction(transactionObj);
		Logger.info(isStatus);
		assertEquals(true, isStatus);
		
	}
}
