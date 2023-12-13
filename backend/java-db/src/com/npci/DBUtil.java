package com.npci;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.Driver;

public class DBUtil {
	// establish connection
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		String DRIVER = Driver.class.getName();
		String URL = "jdbc:postgresql://localhost:5432/npci_db";
		String USERNAME = "postgres";
		String PASSWORD = "Welcome@1234";
		
		// Loading the driver
		Class.forName(DRIVER);
		// Connecting to the DB: import java.sql.Connection, java.sql.DriverManager
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return connection;
	}
	// closing the resources - close(con, stmt, rs);
	public static void close(Connection connection, Statement statement, ResultSet result) 
			throws SQLException {
		if(connection != null) 
			connection.close();
		if(statement != null) 
			statement.close();
		if(result != null) 
			result.close();
	}
}
