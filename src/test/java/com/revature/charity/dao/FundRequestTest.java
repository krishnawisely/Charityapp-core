package com.revature.charity.dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.FundRequest;
import com.revature.charity.util.Logger;

public class FundRequestTest {
	@Test
	public void fundRequestTest()
	{
		FundRequestDAO fundRequest = new FundRequestImpl();
		FundRequest request = new FundRequest();
		Boolean isStatus = null;
		try {
			request.setAdminId(1);
			request.setRequestType("OTHERS");
			request.setDescription("Fund for trees planting");
			request.setAmount(25000D);
			LocalDate expireDate = LocalDate.parse("2019-09-25");
			request.setExpireDate(expireDate);
			isStatus = fundRequest.fundRequest(request);
			assertEquals(true, isStatus);
		} catch (DBException e) {
			Logger.error(e.getMessage());
		}
	}
}
