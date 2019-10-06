package com.revature.charity.service;

import java.util.List;

import com.revature.charity.dao.DonorDAO;
import com.revature.charity.dao.DonorImpl;
import com.revature.charity.exception.DBException;
import com.revature.charity.exception.ServiceException;
import com.revature.charity.exception.ValidatorException;
import com.revature.charity.model.Donor;
import com.revature.charity.util.Logger;
import com.revature.charity.util.MailServiceUtil;
import com.revature.charity.util.MessageConstant;
import com.revature.charity.validator.DonorValidator;

public class DonorServiceImpl implements DonorService{
	/** Donor login **/
	public Donor donorSignin(Donor donor) throws ServiceException
	{
		DonorDAO donorDao = new DonorImpl();
		Donor donorObj = null;
		DonorValidator donorValidator = DonorValidator.getInstance();
		try {
			donorValidator.loginValidator(donor);
			donorObj = donorDao.donorLogin(donor);
			if(donorObj == null)
			{
				throw new ServiceException(MessageConstant.INVALID_EMAIL_AND_PASSWORD);
			}
		} catch (DBException e) {
			Logger.error(e.getMessage());
		} catch (ValidatorException e) {
			Logger.error(e.getMessage());
		}
		return donorObj;
	}
	/** Donor register **/
	public Boolean donorRegister(Donor donor) throws ServiceException
	{
		Boolean isRegister = false;
		DonorDAO donorDao = new DonorImpl();
		DonorValidator donorValidator = DonorValidator.getInstance();
		try {
			donorValidator.registerValidator(donor);
			isRegister = donorDao.donorRegister(donor);
			if(Boolean.FALSE.equals(isRegister))
			{
				throw new ServiceException(MessageConstant.UNABLE_TO_REGISTER);
			} else {
				//Email verification
				String host = "smtp.gmail.com";
		         String username = "krishna192168@gmail.com";
		         String password = "tcadazgqjllzkmba";
		         String fromAddress = "krishna192168@gmail.com";
		         String toAddress = donor.getEmail();
		         String subject = "Password Verification";
		         String text = "Activate Account <a href=\"http://13.232.142.59:8080/Charityapp-frontend/\">Click here</a>";
		         MailServiceUtil.sendMailUsingTLS(host, username, password,
		         fromAddress, toAddress, subject, text);
		         MailServiceUtil.sendMailUsingSSL(host, username, password, fromAddress, toAddress,
		        subject, text);
				//Email verification end
			}
			
		} catch (DBException e) {
			Logger.error(e.getMessage());
		} catch (ValidatorException e) {
			Logger.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		return isRegister;
	}
	/** Donor list **/
	public List<Donor> donorList() throws ServiceException
	{
		List<Donor> list = null; 
		try
		{
			DonorDAO donorDAO = new DonorImpl();
			list = donorDAO.donorList();
		} catch(DBException e) {
			Logger.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		return list;
	}
	/** list funded donors **/
	public List<Donor> listFundedDonor()
	{
		DonorDAO donorDAO = new DonorImpl();
		List<Donor> list = null;
		list = donorDAO.listFundedDonors();
		return list;
	}
}
