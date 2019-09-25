package com.revature.charity.validator;

import com.revature.charity.exception.ValidatorException;
import com.revature.charity.model.FundRequest;
import com.revature.charity.util.MessageConstant;

public class FundRequestValidator {
	private FundRequestValidator()
	{}
	
	static FundRequestValidator fundRequestValidator = new FundRequestValidator();
	public static FundRequestValidator getInstance()
	{
		if(fundRequestValidator == null)
		{
			fundRequestValidator = new FundRequestValidator();
		}
		return fundRequestValidator;
	}
	public void fundRequest(FundRequest request) throws ValidatorException
	{
		String requestType = request.getRequestType();
		String descrition = request.getDescription();
		
		if(requestType == null || "".equals(requestType))
		{
			throw new ValidatorException(MessageConstant.INVALID_REQUEST_TYPE);
		}
		if(descrition == null || "".equals(descrition))
		{
			throw new ValidatorException(MessageConstant.INVALID_DESCRIPTION);
		}
	}
}
