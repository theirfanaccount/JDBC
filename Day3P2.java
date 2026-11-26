//Program to delete a row from a table
//completed till
package com.jdbc;

import java.sql.*;

public class Day3P2 {
	private static final String URL = "jdbc:mysql://localhost:3306/company";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Your_pass";
	private static final String QUERY = "DELETE FROM `departments` WHERE `dept_name` = 'it'";
	
	public static void main(String[] args)  {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			Statement stat = con.createStatement()) {
			int result  = stat.executeUpdate(QUERY);
			System.out.println(result);
			 
		}
		 catch (SQLException e) {
			e.printStackTrace();
		 }
	}
}
