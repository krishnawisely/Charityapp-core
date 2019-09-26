package com.revature.charity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.charity.exception.DBException;
import com.revature.charity.model.Transaction;
import com.revature.charity.util.ConnectionUtil;
import com.revature.charity.util.Logger;
import com.revature.charity.util.MessageConstant;

public class TransactionImpl implements TransactionDAO {
	/** Transaction **/
	public Boolean transaction(Transaction transaction) throws DBException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		Boolean isStatus = false;
		try {
			conn = ConnectionUtil.getConnection();
			String sqlStmt = "INSERT INTO transaction(donor_id,fund_request_id,amount) VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sqlStmt);
			
			Integer donorId = transaction.getDonorId();
			Integer fundRequestId = transaction.getfundRequestId();
			Double amount = transaction.getAmount();
			
			
			pstmt.setInt(1, donorId);
			pstmt.setInt(2, fundRequestId);
			pstmt.setDouble(3, amount);
			int rows = pstmt.executeUpdate();
			if(rows == 1)
			{
				isStatus = true;
			}
		} catch(SQLException e) {
			Logger.error(e);
			throw new DBException(MessageConstant.UNABLE_TO_TRANSACTION,e);
		}
		return isStatus;
	}
}
