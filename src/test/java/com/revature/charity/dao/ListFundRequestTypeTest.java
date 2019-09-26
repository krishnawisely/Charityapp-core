package com.revature.charity.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.FundRequest;
import com.revature.charity.util.Logger;

public class ListFundRequestTypeTest {
	@Test
	public void listRequest()
	{
		FundRequestDAO fundRequest = new FundRequestImpl();
		try {
			List<FundRequest> lists = fundRequest.findByRquestType("EDUCATION");
			for(FundRequest list : lists)
			{
				Logger.info(list);
			}
			assertNotNull(lists);
		} catch (DBException e) {
			Logger.error(e.getMessage());
		}
	}
}
