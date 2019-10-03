package com.revature.charity.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.Admin;
import com.revature.charity.util.Logger;

public class adminLoginTest {
	@Test
	public void adminLogin()
	{
		AdminDAO adminDAO = new AdminImpl();
		Admin admin = new Admin();
		Admin adminObj = new Admin();
		admin.setEmail("admin@gmail.com");
		admin.setPassword("mypass");
		try {
			adminObj = adminDAO.adminLogin(admin);
			assertNotNull(adminObj);
		} catch (DBException e) {
			Logger.debug(e.getMessage());
		}
	}
}
