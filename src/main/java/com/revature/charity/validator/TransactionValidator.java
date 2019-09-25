package com.revature.charity.validator;

import com.revature.charity.exception.ValidatorException;
import com.revature.charity.model.Transaction;

public class TransactionValidator {
	
	private TransactionValidator()
	{}
	
	static TransactionValidator transactionValidator = null;
	public static TransactionValidator getInstance()
	{
		if(transactionValidator == null)
		{
			transactionValidator = new TransactionValidator();
		}
		return transactionValidator;
	}

	/** Transaction validator **/
	public void loginValidator(Transaction transaction) throws ValidatorException
	{
		Double amount = transaction.getAmount();
		
		if(amount < 0)
		{
			throw new ValidatorException("Invalid amount");
		}
	}
}
