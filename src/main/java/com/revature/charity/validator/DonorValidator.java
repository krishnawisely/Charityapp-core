package com.revature.charity.validator;

import com.revature.charity.dao.DonorDAO;
import com.revature.charity.dao.DonorImpl;
import com.revature.charity.exception.DBException;
import com.revature.charity.exception.ValidatorException;
import com.revature.charity.model.Donor;
import com.revature.charity.util.Logger;
import com.revature.charity.util.MessageConstant;


public class DonorValidator {
	/** Login validator **/
	public static void loginValidator(Donor donor) throws ValidatorException
	{
		String email = donor.getEmail();
		String password = donor.getPassword();
		
		if(email == null || "".equals(email))
		{
			throw new ValidatorException(MessageConstant.INVALID_EMAIL);
		}
		if(password == null || "".equals(password))
		{
			throw new ValidatorException(MessageConstant.INVALID_PASSWORD);
		}
	}
	/** Register validator **/
	public static void registerValidator(Donor donor) throws ValidatorException
	{
		String email = donor.getEmail();
		String password = donor.getPassword();
		
		DonorDAO donorDao = new DonorImpl();
		Donor donorObj = new Donor();
		try {
			donorObj = donorDao.isEmailExist(email);
			if(donorObj != null)
			{
				throw new ValidatorException(MessageConstant.EMAIL_EXIST);
			}
		} catch (DBException e) {
			Logger.error(e);
		}
		
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
