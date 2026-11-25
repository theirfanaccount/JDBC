// closing JDBC resources inside the try block

package com.jdbc;
import java.sql.*;

public class Day2P1 {
	private static final String URL = "jdbc:mysql://localhost:3306/product";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Your_pass";
	private static final String QUERY = "SELECT * FROM products";
	
	public static void main(String[] args) {
		// 1. loading driver
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 System.out.println("Driver loaded");
		 }
		 catch(ClassNotFoundException e) {
			 e.printStackTrace();
		 }
		 // 2-4. Connect, create statement, execute (all closed automatically)
		 try(Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			 Statement stmt = con.createStatement();
			 ResultSet result = stmt.executeQuery(QUERY)){
			 
			 	System.out.println("Connected: " + con);
			 	displayProduct(result);
		 }
	     catch (SQLException e) {
	         e.printStackTrace();
	     }
	}
	// method to display the result
	public static void displayProduct(ResultSet result) throws SQLException {
		System.out.println("-------------------------------------------------");
        while(result.next()) {
       	 int id = result.getInt("product_id");
       	 String name = result.getString("name");
       	 String category = result.getNString("category");
       	 /*
       	   or 
       	   	result.getInt(1);
       	 	result.getString(2);
       	 	.....
       	  */
       	 System.out.printf("|%-3d |%-20s |%-20s|\n",id,name,category);
        }
        System.out.println("-------------------------------------------------");
	}
}
