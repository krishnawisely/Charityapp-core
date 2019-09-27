package com.revature.charity.dao;
import java.util.List;

import org.junit.Test;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.Donor;
import com.revature.charity.util.Logger;

public class ListDonorTest {
	@Test
	public void listDonor()
	{
		DonorDAO donorObj = new DonorImpl();
		List<Donor> list = null;
		try {
			
			list = donorObj.donorList();
			Logger.info(list);
		} catch (DBException e) {
		Logger.error(e.getMessage());
		}
	}
}
