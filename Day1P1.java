package com.jdbc;


import java.sql.*;
public class Day1P1 {
	private static final String URL = "jdbc:mysql://localhost:3306/company";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Root@1234";
	private static final String QUERY = "SELECT * FROM employees";
	
	public static void main(String[] args) {
	     Connection con = null;
	     Statement stmt = null;
	     ResultSet result = null;
		 
		 try {
			// 1. loading driver
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 System.out.println("Driver loaded");
			 
			// 2. Establishing connection to the databse
			 con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	         System.out.println("Connected: " + con);
	         
	         // 3. Create a sql statement
	         stmt = con.createStatement();
	         
	         // 4. Execute the SQL statement
	         
	         result = stmt.executeQuery(QUERY);
	         
	         // 5 . process the result
	         displayEmployee(result);
		 }
	     catch (SQLException e) {
	         e.printStackTrace();
	     }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 // 6. Closing the opening resources
		 finally {
			 close(con, stmt, result);
		 } 
	 }
	// Display output
	private static void displayEmployee(ResultSet result) throws SQLException {
		System.out.println("-----------------");
        while(result.next()) {
       	 int id = result.getInt("id");
       	 String name = result.getString("name");
       	 /*
       	   or 
       	   	result.getInt(1);
       	 	result.getString(2);
       	  */
       	 System.out.printf("|%-3d |%-10s|\n",id,name);
        }
        System.out.println("-----------------");
	}
	// Closing the resources
	private static void close(Connection con,Statement stat,ResultSet result) {
		try {
			result.close();
			stat.close();
			con.close();	
		} 
		catch (SQLException e) {
				e.printStackTrace();
		}
		 
	}
	
}

