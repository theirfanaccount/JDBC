//Update a column on a specific condition
package com.jdbc;

import java.sql.*;
import java.util.Scanner;

public class Day4P2 {
	public static final String URL = "jdbc:mysql://localhost:3306/product";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "Your_pass";
	public static final String QUERY = "UPDATE `products` SET `price` = `price` + ? WHERE `category` = ?";
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)){
			System.out.print("Enter the product category: ");
			String category = scan.nextLine().trim();

			System.out.print("Enter the price you want to increase: ");
			int incPrice;
			try {
				incPrice = Integer.parseInt(scan.nextLine().trim());
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid input: please enter a whole number");
				return;
			}

			int rows = updatePrice(category,incPrice);
			if(rows > 0) {
				System.out.println("Number of rows affected: " + rows);
			}
			else {
				System.out.println("Category not found");
			}
		}
		catch(SQLException e) {
			System.out.println("Database error: " + e.getMessage());
		}
	}
	public static int updatePrice(String category,int incPrice) throws SQLException {
		try(Connection con  = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = con.prepareStatement(QUERY)){
				ps.setInt(1,incPrice);
				ps.setString(2, category);
				return ps.executeUpdate();	
		}
		
	}
}
