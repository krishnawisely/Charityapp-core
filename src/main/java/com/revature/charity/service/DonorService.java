package com.revature.charity.service;

import java.util.List;

import com.revature.charity.exception.ServiceException;
import com.revature.charity.model.Donor;


public interface DonorService {
	public Donor donorSignin(Donor donor) throws ServiceException;
	public Boolean donorRegister(Donor donor) throws ServiceException;
	public List<Donor> donorList() throws ServiceException;
}
