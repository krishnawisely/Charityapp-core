package com.revature.charity.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.revature.charity.exception.ServiceException;
import com.revature.charity.model.Donor;
import com.revature.charity.util.Logger;

public class DonorList {
	
	@Test
	public void donorListTest()
	{
		List<Donor> list = null;
		try {
			DonorService donorService = new DonorServiceImpl();
			list = donorService.donorList();
			assertNotNull(list);
		} catch (ServiceException e) {
			Logger.error(e.getMessage());
		}
		Logger.info(list);
	}

}
