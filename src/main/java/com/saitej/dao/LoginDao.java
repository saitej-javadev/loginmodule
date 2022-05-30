package com.saitej.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	

	

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/schooldb";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String SELECT = "SELECT * FROM USER WHERE USERNAME=? AND PASSWORD=?";

	public boolean check(String uname,String password) {
		
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = con.prepareStatement(SELECT);
			ps.setString(1, uname);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return false;
		
	}

}
