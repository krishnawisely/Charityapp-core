package com.revature.charity.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.Donor;
import com.revature.charity.util.Logger;

public class DonorLoginTest {
	@Test
	public void donorLoginTest()
	{
		DonorDAO donorDAO = new DonorImpl();
		Donor donor = new Donor();
		Donor donorObj = new Donor();
		donor.setEmail("krishna192168@gmail.com");
		donor.setPassword("mypass123");
		try {
			donorObj = donorDAO.donorLogin(donor);
			assertNotNull(donorObj);
		} catch (DBException e) {
			Logger.debug(e.getMessage());
		}
	}
}
