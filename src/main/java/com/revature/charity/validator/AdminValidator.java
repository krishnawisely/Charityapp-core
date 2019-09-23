package com.revature.charity.validator;

import com.revature.charity.exception.ValidatorException;
import com.revature.charity.model.Admin;
import com.revature.charity.util.MessageConstant;

public class AdminValidator {
	/** Login validator **/
	public static void loginValidator(Admin admin) throws ValidatorException
	{
		String email = admin.getEmail();
		String password = admin.getPassword();
		
		if(email == null || "".equals(email))
		{
			throw new ValidatorException(MessageConstant.INVALID_EMAIL);
		}
		if(password == null || "".equals(password))
		{
			throw new ValidatorException(MessageConstant.INVALID_PASSWORD);
		}
	}
}
