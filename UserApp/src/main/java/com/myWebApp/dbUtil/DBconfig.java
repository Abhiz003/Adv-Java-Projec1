package com.myWebApp.dbUtil;

public interface DBconfig {
	//final variable name should be cpaital
	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String CON_URL = "jdbc:mysql://localhost:3306/javadb"; 
	String USERNAME = "root";
	String PASSWORD = "root";
}
