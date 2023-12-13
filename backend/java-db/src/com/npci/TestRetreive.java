package com.npci;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

import org.postgresql.Driver;

public class TestRetreive {
	public static void main(String[] args) {
		try {
			// JDBC properties
			String DRIVER = Driver.class.getName();
			String URL = "jdbc:postgresql://localhost:5432/npci_db";
			String USERNAME = "postgres";
			String PASSWORD = "Welcome@1234";
			
			// Loading the driver
			Class.forName(DRIVER);
			// Connecting to the DB: import java.sql.Connection, java.sql.DriverManager
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			System.out.println("Connected: "+connection); // prints address of the object if connected
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter RollNo:-");
			int rollNo = scan.nextInt(); // reads the int value
			// write the query that searches Student based on the rollNo;
			String SELECT_QUERY = "select * from student where roll_no = ?";
			// prepared statement - 3rd step - import java.sql.PreparedStatement
			PreparedStatement statement = connection.prepareStatement(SELECT_QUERY);
			// set the value to the ?
			statement.setInt(1, rollNo); // sets the user input to the ?1
			// execute the query - 4th step - import java.sql.ResultSet
			ResultSet result = statement.executeQuery(); 
			// result is a sql object, which you must traverse using getter methods
			// next() method navigates to the next record if present
			if(result.next()) {
				// call the getters to get the values 
				int x = result.getInt(1); // 1st column value is assigned
				String y = result.getString(2); // 2nd column value is varchar hence getString
				LocalDate z = result.getDate(3).toLocalDate(); // 3nd column value is date
				System.out.println("RollNo = "+x+", Name = "+y+ ", Dob = "+z);
				// Note: you can pass x,y,z to the Student class constructor
				// Student s = new Student(x, y, z); 
			} else {
				System.err.println("No records with the rollno: "+rollNo+" is found!");
			}
			// close the resources including scanner object
			result.close();	statement.close();	connection.close();
			scan.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
