package com.mindtree.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DatabaseConnection {
	private final static String URL = "jdbc:mysql://localhost:3306/hotel";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "Divya@1998";

	public static Connection connect() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//System.out.println("Connection suceess full!!!");
		} catch (Exception e) {
			//System.out.println(e + "   connection failure");
		}
		return con;

	}

	public static void close(Connection con, PreparedStatement pst) {
		if (con != null && pst != null) {
			try {
				pst.close();
				con.close();
				//System.out.println(" Connection closed Successfully!!!");

			} catch (Exception e) {
				System.out.println("Error :  " + e);
			}
		} else {
			//System.out.println("connection not established");
		}

	}

	public static void close(Connection con, Statement st) {
		if (con != null && st != null) {
			try {
				st.close();
				con.close();
				//System.out.println(" Connection closed Successfully!!!");

			} catch (Exception e) {
				System.out.println("Error :  " + e);
			}
		} else {
			//System.out.println("Connection not estableshed");

		}
	}

}
