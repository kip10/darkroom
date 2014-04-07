package com.example.darkroom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseQueryer {	
	private static String hostName = "localhost";
	private static Integer portNumber = 3306;
	private static String dbName = "dr0";
	private static String userName = "root";
	private static String password = "newpwd";
	
	public static ResultSet connectToAndQueryDatabase(String query) throws SQLException, Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dr0", "root", "newpwd");
		PreparedStatement stmt = dbConn.prepareStatement(query);
		return stmt.executeQuery(query);
	}

	public static void connectToAndUpdateDatabase(String statement) throws SQLException, Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dr0", "root", "newpwd");
		PreparedStatement stmt = dbConn.prepareStatement(statement);
		stmt.executeUpdate(statement);
	}
	
	
}