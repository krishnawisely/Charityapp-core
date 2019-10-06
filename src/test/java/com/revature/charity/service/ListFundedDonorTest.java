package com.revature.charity.service;

import java.util.List;

import org.junit.Test;

import com.revature.charity.model.Donor;

public class ListFundedDonorTest {

	@Test
	public void listFundedAmount()
	{
		DonorService donorObj = new DonorServiceImpl();
		List<Donor> list = null;
		list = donorObj.listFundedDonor();
		for(Donor donor : list)
		{
			System.out.println(donor);
		}
	}
	
}
