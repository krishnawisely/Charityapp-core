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
		transactionObj.setDonorId(1);
		transactionObj.setfundRequestId(11);
		transactionObj.setAmount(5000D);
		Boolean isStatus = service.transaction(transactionObj);
		Logger.info(isStatus);
		assertEquals(true, isStatus);
	}
}
