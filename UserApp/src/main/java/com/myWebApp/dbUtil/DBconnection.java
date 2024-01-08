package com.myWebApp.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	static 
	{
		try {
			Class.forName(DBconfig.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public Connection createConnection() {
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBconfig.CON_URL, DBconfig.USERNAME, DBconfig.PASSWORD);
			
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "root");
			System.out.println(con==null ? "notconnected" : "connected");
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
