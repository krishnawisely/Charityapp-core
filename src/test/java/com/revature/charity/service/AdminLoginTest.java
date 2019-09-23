package com.revature.charity.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.revature.charity.exception.ServiceException;
import com.revature.charity.model.Admin;
import com.revature.charity.util.Logger;

public class AdminLoginTest {
	@Test
	public void adminLoginTest()
	{
		AdminService serivce = new AdminServiceImpl();
		Admin admin = new Admin();
		Admin adminObj = new Admin();
		admin.setEmail("admin@gmail.com");
		admin.setPassword("mypass");
		try {
			adminObj = serivce.adminLoginService(admin);
		} catch (ServiceException e) {
			Logger.error(e.getMessage());
		}
		assertNotNull(adminObj);
	}
}
