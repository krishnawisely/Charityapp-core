package com.revature.charity.dao;

import java.util.List;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.Donor;

public interface DonorDAO {
	public Donor donorLogin(Donor donor) throws DBException;
	public Boolean donorRegister(Donor donor) throws DBException;
	public Donor isEmailExist(String email) throws DBException;
	public List<Donor> donorList() throws DBException;
	public List<Donor> listFundedDonors();
}
