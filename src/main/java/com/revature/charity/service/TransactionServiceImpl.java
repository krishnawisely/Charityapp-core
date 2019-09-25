package com.revature.charity.service;

import com.revature.charity.dao.TransactionDAO;
import com.revature.charity.dao.TransactionImpl;
import com.revature.charity.exception.DBException;
import com.revature.charity.exception.ValidatorException;
import com.revature.charity.model.Transaction;
import com.revature.charity.util.Logger;
import com.revature.charity.validator.TransactionValidator;

public class TransactionServiceImpl implements TransactionService {
	public Boolean transaction(Transaction transactionObj)
	{
		TransactionDAO transaction = new TransactionImpl();
		TransactionValidator transactionValidator = TransactionValidator.getInstance();
		Boolean isStatus = false;
		try {
			
				transactionValidator.loginValidator(transactionObj);	
			
				isStatus = transaction.transaction(transactionObj);
		}catch (DBException e) {
			Logger.error(e.getMessage());
		} 
		catch (ValidatorException e) {
			Logger.error(e.getMessage());
		}
		return isStatus;
	}
}
