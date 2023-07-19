package com.hks.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	public static Connection createConnection() throws SQLException{
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hks", "root", "Henry@2005");
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		return con;
		
	}
}
