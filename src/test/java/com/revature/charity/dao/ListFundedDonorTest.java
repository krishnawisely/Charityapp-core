package com.revature.charity.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.Donor;
import com.revature.charity.util.Logger;

public class ListFundedDonorTest {
	
	@Test
	public void listFundedDonor()
	{
		DonorDAO donorDAOObj = new DonorImpl();
		
		List<Donor> list = null;
		try {
			list = donorDAOObj.listFundedDonors();
			assertNotNull(list);
			
			for(Donor donor : list)
			{
				System.out.println(donor);
			}
		} catch (DBException e) {
			Logger.error(e.getMessage());
		}
		
	}

}
