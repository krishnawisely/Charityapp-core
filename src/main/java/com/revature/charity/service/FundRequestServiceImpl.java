package com.revature.charity.service;

import java.util.List;

import com.revature.charity.dao.FundRequestDAO;
import com.revature.charity.dao.FundRequestImpl;
import com.revature.charity.exception.DBException;
import com.revature.charity.exception.ValidatorException;
import com.revature.charity.model.FundRequest;
import com.revature.charity.util.Logger;
import com.revature.charity.validator.FundRequestValidator;

public class FundRequestServiceImpl implements FundRequestService {
	/** Fund request **/
	public Boolean fundRequestService(FundRequest request)
	{
		FundRequestDAO requestDao = new FundRequestImpl();
		FundRequestValidator fundRequestValidator = FundRequestValidator.getInstance();
		Boolean isStatus = null;
		try {
			fundRequestValidator.fundRequest(request);
			isStatus = requestDao.fundRequest(request);
		} catch (DBException e) {
			Logger.error(e.getMessage());
		} catch (ValidatorException e) {
			Logger.error(e.getMessage());
		}
		return isStatus;
	}
	/** List fund request **/
	public List<FundRequest> listFundRequest(String requestType)
	{
		FundRequestDAO requestDao = new FundRequestImpl();
		List<FundRequest> list = null;
		try {
			list = requestDao.findByRquestType(requestType);
		} catch (DBException e) {
			Logger.error(e.getMessage());
		}
		return list;
	}
	/*
	 * update fund request
	 * */
	public Boolean updateFundRequest(FundRequest fundRequest)
	{
		FundRequestDAO fundRequestDAO = new FundRequestImpl();
		Boolean isFundUpdated = null;
		try {
			isFundUpdated = fundRequestDAO.updateRequest(fundRequest);
		} catch (DBException e) {
			Logger.error(e.getMessage());
		}
		return isFundUpdated;
	}
}
