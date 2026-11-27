package com.jdbc;

import java.sql.*;
import java.util.Scanner;

public class Day4 {
	public static final String URL = "jdbc:mysql://localhost:3306/company";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "Your_pass";
	public static final String QUERY = "SELECT * FROM `departments` WHERE `dept_name` = ?";
	// ? :- place holder
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
		try(Scanner scan = new Scanner(System.in);){
			System.out.print("Enter the department: ");
            String deptName = scan.nextLine().trim();
            findDepartment(deptName);
		}
		
		
	}
	private static void findDepartment(String deptName) {
		try(Connection con  = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = con.prepareStatement(QUERY)){
				ps.setString(1,deptName);
				try(ResultSet result = ps.executeQuery();){
					printResult(result);
				}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
			
	}
	private static void printResult(ResultSet result) throws SQLException {
		// next() moves to the first row; false means no row matched
		if(!result.next()) {
			System.out.println("Department not found");
			return;
		}
		System.out.println("-----------------------------");
		//do-while Because the check if(!result.next()) has already moved the cursor to the first row.
		do {
			int dept_id = result.getInt("dept_id");
			String dept_name = result.getString("dept_name");
			String location = result.getString("location");
			System.out.printf("|%-3d |%-10s |%-10s|\n",dept_id,dept_name,location);
		} while(result.next());
		System.out.println("-----------------------------");
	}
}
