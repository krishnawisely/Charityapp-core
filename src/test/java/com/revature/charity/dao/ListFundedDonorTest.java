package com.revature.charity.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.revature.charity.model.Donor;

public class ListFundedDonorTest {
	
	@Test
	public void listFundedDonor()
	{
		DonorDAO donorDAOObj = new DonorImpl();
		
		List<Donor> list;
		list = donorDAOObj.listFundedDonors();
		assertNotNull(list);
		
		for(Donor donor : list)
		{
			System.out.println(donor);
		}
	}

}
