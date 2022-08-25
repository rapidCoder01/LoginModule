package com.LoginModule.Register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/HomeCare";
	private String dbUname = "root";
	private String dbPassword = "Debnath@123";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public void loadDriver()
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
		public Connection getConnection()
		{
			Connection con = null;
			try {
				con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		}
}
