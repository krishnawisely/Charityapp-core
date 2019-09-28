package com.revature.charity.service;

import java.util.List;

import com.revature.charity.dao.DonorDAO;
import com.revature.charity.dao.DonorImpl;
import com.revature.charity.exception.DBException;
import com.revature.charity.exception.ServiceException;
import com.revature.charity.exception.ValidatorException;
import com.revature.charity.model.Donor;
import com.revature.charity.validator.DonorValidator;

public class DonorServiceImpl implements DonorService{
	/** Donor login service 
	 * @throws ServiceException **/
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
				throw new ServiceException("Invalid username and password");
			}
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage());
		}
		return donorObj;
	}
	/** Donor register service 
	 * @throws ServiceException 
	 * @throws DBException **/
	public Boolean donorRegister(Donor donor) throws ServiceException
	{
		Boolean result = false;
		DonorDAO donorDao = new DonorImpl();
		DonorValidator donorValidator = DonorValidator.getInstance();
		try {
			donorValidator.registerValidator(donor);
			result = donorDao.donorRegister(donor);
			if(!result)
			{
				throw new ServiceException("Invalid register");
			}
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage());
		}
		return result;
	}
	
	public List<Donor> donorList() throws ServiceException
	{
		List<Donor> list = null; 
		try
		{
			DonorDAO donorDAO = new DonorImpl();
			list = donorDAO.donorList();
		} catch(DBException e) {
			throw new ServiceException(e.getMessage());
		}
		return list;
	}
}
