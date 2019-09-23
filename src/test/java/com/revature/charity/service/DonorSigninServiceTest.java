package com.revature.charity.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.revature.charity.exception.ServiceException;
import com.revature.charity.model.Donor;
import com.revature.charity.util.Logger;

public class DonorSigninServiceTest {
	@Test
	public void donorSigninServiceTest()
	{
		DonorService service = new DonorServiceImpl();
		Donor donor = new Donor();
		Donor donorObj = new Donor();
		donor.setEmail("krishna@gmail.com");
		donor.setPassword("mypass");
		try {
			donorObj = service.donorSignin(donor);
		} catch (ServiceException e) {
			Logger.error(e.getMessage());
		}
		assertNotNull(donorObj);
	}
}
