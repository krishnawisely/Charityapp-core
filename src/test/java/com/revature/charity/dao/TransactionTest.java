package com.revature.charity.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.Transaction;
import com.revature.charity.util.Logger;

public class TransactionTest {
	@Test
	public void transactionTest()
	{
		Transaction transaction = new Transaction();
		TransactionDAO transactionDAO = new TransactionImpl();
		try {
			transaction.setfundRequestId(158);
			transaction.setDonorId(79);
			transaction.setAmount(100D);
			Boolean isStatus = transactionDAO.transaction(transaction);
			Logger.error(isStatus);
			assertEquals(true, isStatus);
		} catch (DBException e) {
			Logger.info(e.getMessage());
		}
	}
}
