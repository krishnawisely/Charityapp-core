package com.revature.charity.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class ConnectionUtil {
	static Logger logger = new Logger();
	/** Get connection **/
		public static Connection getConnection()
		{	
			final String driverClass = "com.mysql.cj.jdbc.Driver";
			final String url = "jdbc:mysql://trainingdb.ck1ayq0lncmp.ap-south-1.rds.amazonaws.com:3306/krishna_db";
			final String userName = "krishna";
			final String password = "krishna";
			Connection conn = null;
			try {
				Class.forName(driverClass);
				conn = DriverManager.getConnection(url,userName,password);
			}
			catch(ClassNotFoundException e)
			{
				logger.debug(e.getMessage());
			}
			catch(SQLException e)
			{
				logger.debug(e.getMessage());
			}
			return conn;
		}
		
		public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs)
		{
			try {
				if(conn != null)
					conn.close();
				if(pstmt != null)
					pstmt.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				logger.debug(e.getMessage());
			}
		}
		
}
