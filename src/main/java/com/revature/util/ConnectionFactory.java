package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	// Private Constructor to enforce usage of factory method
	private ConnectionFactory() {}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(System.getenv("JDBC_URL"), 
											   System.getenv("JDBC_USERNAME"), 
											   System.getenv("JDBC_PASSWORD"));
		} catch (SQLException e) {
			System.err.println("Error Code: " + e.getErrorCode());
			System.err.println("SQL State: " + e.getSQLState());
			throw new RuntimeException("Failed to get database connection");
		} 
	}
}
