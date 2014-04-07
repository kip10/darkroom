package com.example.darkroom;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQueryer {
		private static String hostName = "31.170.160.98";
		private static Integer portNumber = 3306;
		private static String userName = "a2884703_klaw";
		private static String password = "Eklawitter1";

		public static ResultSet connectToAndQueryDatabase(String query) throws SQLException {
			Connection dbConn;
			dbConn = DriverManager.getConnection(
					"jdbc:mysql://" + hostName + ":" + portNumber + "/a2884703_darkroo?user=" + userName + "&password=" + password);
			Statement stmt = dbConn.createStatement();
			return stmt.executeQuery(query);
		}
		
		
		
		public static void connectToAndUpdateDatabase(String statement) throws SQLException {
			Connection dbCon = DriverManager.getConnection(
					"jdbc:mysql://" + hostName + ":" + portNumber + "/a2884703_darkroo?user=" + userName + "&password=" + password);
			Statement stmt = dbCon.createStatement();
			stmt.executeUpdate(statement);
		}
}
