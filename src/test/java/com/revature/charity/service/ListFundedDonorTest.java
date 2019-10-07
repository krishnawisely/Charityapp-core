package com.revature.charity.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.revature.charity.exception.ServiceException;
import com.revature.charity.model.Donor;
import com.revature.charity.util.Logger;

public class ListFundedDonorTest {

	@Test
	public void listFundedAmount()
	{
		DonorService donorObj = new DonorServiceImpl();
		List<Donor> list = null;
		try {
			list = donorObj.listFundedDonor();
			assertNotNull(list);
			for(Donor donor : list)
			{
				System.out.println(donor);
			}
		} catch (ServiceException e) {
			Logger.error(e.getMessage());
		}
		
	}
	
}
