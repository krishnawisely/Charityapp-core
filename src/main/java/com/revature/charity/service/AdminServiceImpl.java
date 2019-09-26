package com.revature.charity.service;

import com.revature.charity.dao.AdminDAO;
import com.revature.charity.dao.AdminImpl;
import com.revature.charity.exception.DBException;
import com.revature.charity.exception.ServiceException;
import com.revature.charity.exception.ValidatorException;
import com.revature.charity.model.Admin;
import com.revature.charity.util.MessageConstant;
import com.revature.charity.validator.AdminValidator;

public class AdminServiceImpl implements AdminService {
	public Admin adminLoginService(Admin admin) throws ServiceException
	{
		AdminDAO adminDao = new AdminImpl();
		Admin adminObj = new Admin();
		AdminValidator adminValidator = AdminValidator.getInstance();
		try {
			adminValidator.loginValidator(admin);
			adminObj = adminDao.adminLogin(admin);
			if(adminObj == null)
			{
				throw new ServiceException(MessageConstant.INVALID_NAME_AND_PASSWORD);
			}
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		} 
		catch (ValidatorException e) {
			throw new ServiceException(e.getMessage());
		}
		return adminObj;
	}
}
