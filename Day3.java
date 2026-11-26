
// program to insert a row in a table 
package com.jdbc;

import java.sql.*;

public class Day3 {
	private static final String URL = "jdbc:mysql://localhost:3306/company";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Your_pass";
	private static final String QUERY =
	        "INSERT INTO `departments` (`dept_id`, `dept_name`, `location`) " +
	        "VALUES (10, 'Finance', 'Banglore')"; 
			//backticks are used for standerisation
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			Statement stat = con.createStatement()) {
				int result = stat.executeUpdate(QUERY); // it return the number of rows affected
				System.out.println("Number of inserted row "+result);
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
