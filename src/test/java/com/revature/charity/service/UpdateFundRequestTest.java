package com.revature.charity.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import com.revature.charity.model.FundRequest;

public class UpdateFundRequestTest {
	@Test
	public void updateFundRequestTest()
	{
		
		FundRequestService fundRequestObj = new FundRequestServiceImpl();
		FundRequest fundRequest = new FundRequest();
		
		fundRequest.setId(1);
		fundRequest.setRequestType("MEDICAL");
		fundRequest.setDescription("Medic fund for heart transfer");
		LocalDate expireDate = LocalDate.parse("2019-12-12");
		fundRequest.setExpireDate(expireDate);
		fundRequest.setAmount(16000D);
		
		 Boolean isFundUpdated = fundRequestObj.updateFundRequest(fundRequest);
		 
		 assertEquals(true, isFundUpdated);
	}
}
