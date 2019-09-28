package com.revature.charity.dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.FundRequest;
import com.revature.charity.util.Logger;

public class UpdateFundRequestTest {
	
	@Test
	public void updateFundRequest()
	{
		FundRequestDAO fundRequestObj = new FundRequestImpl();
		FundRequest fundRequest = new FundRequest();
		try {
			fundRequest.setId(1);
			fundRequest.setRequestType("Food");
			fundRequest.setDescription("Food fund for childrens");
			LocalDate expireDate = LocalDate.parse("2019-11-12");
			fundRequest.setExpireDate(expireDate);
			fundRequest.setAmount(15000D);
			Boolean isFundUpdated = fundRequestObj.updateRequest(fundRequest);
			assertEquals(true, isFundUpdated);
		} catch (DBException e) {
			Logger.error(e.getMessage());
		}
	}

}
