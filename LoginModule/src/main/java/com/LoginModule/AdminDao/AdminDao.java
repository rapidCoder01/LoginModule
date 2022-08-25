package com.LoginModule.AdminDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.LoginModule.AdminBean.AdminBean;

public class AdminDao {
	

	private String dbUrl = "jdbc:mysql://localhost:3306/HomeCare";
	private String dbUname = "root";
	private String dbPassword = "Debnath@123";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public void loadDriver(String dbDriver)
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
	
	public boolean validate(AdminBean Adminbean) {
		boolean status = false;
		
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		String sql = "Select * from HomeCare.AdminAcc where username = ? and password = ?";
		try {
			PreparedStatement st =con.prepareStatement(sql);
			//st.setInt(1, id);
			st.setString(1, Adminbean.getAdminname());
			st.setString(2, Adminbean.getAdminpwd());
			ResultSet rs = st.executeQuery();
			status =rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;	
	}
}
