package com.revature.charity.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.Donor;
import com.revature.charity.util.ConnectionUtil;
import com.revature.charity.util.Logger;
import com.revature.charity.util.MessageConstant;

public class DonorImpl implements DonorDAO{
	/** Donor Login **/
	public Donor donorLogin(Donor donor) throws DBException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Donor donorObj = null;
		try {
			conn = ConnectionUtil.getConnection();
			String sqlStmt = "SELECT id,name,email FROM donor WHERE email = ? AND password = ?";
			pstmt = conn.prepareStatement(sqlStmt);
			pstmt.setString(1, donor.getEmail());
			pstmt.setString(2, donor.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				donorObj = new Donor();
				donorObj.setId(rs.getInt("id"));
				donorObj.setName(rs.getString("name"));
				donorObj.setEmail(rs.getString("email"));
			}
		} catch(SQLException e)
		{
			Logger.error(e);
			throw new DBException(MessageConstant.UNABLE_TO_LOGIN,e);
		} finally {
			ConnectionUtil.close(conn, pstmt, null);
		}
		return donorObj;
	}
	/** Donor register **/
	public Boolean donorRegister(Donor donor) throws DBException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		Boolean result = false;
		try {
			conn = ConnectionUtil.getConnection();
			String sqlStmt = "INSERT INTO donor(name,email,password,date_of_birth,gender) VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sqlStmt);
			//Convert local date into date
			Date dateOfBirth = Date.valueOf(donor.getDateOfBirth());
			
			pstmt.setString(1, donor.getName());
			pstmt.setString(2, donor.getEmail());
			pstmt.setString(3, donor.getPassword());
			pstmt.setDate(4, dateOfBirth);
			pstmt.setString(5, donor.getGender());
			
			int rows = pstmt.executeUpdate();
			//Check user is logged in or not
			if(rows == 1)
			{
				result = true;
			}
		} catch(SQLException e) {
			Logger.error(e);
			throw new DBException(MessageConstant.UNABLE_TO_REGISTER,e);
		} finally {
			ConnectionUtil.close(conn, pstmt, null);
		}
		return result;
	}
	/** Check email is exist or not **/
	public Donor isEmailExist(String email) throws DBException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Donor donorObj = null;
		try {
			conn = ConnectionUtil.getConnection();
			String sqlStmt = "SELECT name,email FROM donor WHERE email = ?";
			pstmt = conn.prepareStatement(sqlStmt);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				donorObj = new Donor();
				donorObj.setName(rs.getString("name"));
				donorObj.setEmail(rs.getString("email"));
			}
		} catch(SQLException e)
		{
			Logger.error(e);
			throw new DBException(MessageConstant.UNABLE_TO_CHECK_EMAIL,e);
		} finally {
			ConnectionUtil.close(conn, pstmt, null);
		}
		return donorObj;
	}
	/**
	 * List donor details
	 * @throws DBException 
	 * **/
	public List<Donor> donorList() throws DBException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		Donor donorObj = null;
		List<Donor> list = null;
		try {
			list = new ArrayList<Donor>();
			donorObj = new Donor();
			conn = ConnectionUtil.getConnection();
			String sqlStmt = "select id,name,email,gender,date_of_birth,active from donor";
			pstmt = conn.prepareStatement(sqlStmt);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				LocalDate dob = LocalDate.parse(rs.getString("date_of_birth"));
				donorObj.setId(rs.getInt("id"));
				donorObj.setName(rs.getString("name"));
				donorObj.setEmail(rs.getString("email"));
				donorObj.setPassword(rs.getString("gender"));
				donorObj.setDateOfBirth(dob);
				donorObj.setActive(rs.getString("active"));
				list.add(donorObj);
			}
			
		} catch(SQLException e) {
			throw new DBException(e.getMessage());
		}
		
		return list;
	}
}
