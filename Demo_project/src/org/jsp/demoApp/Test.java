package org.jsp.demoApp;

import java.sql.*;

public class Test {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String qry="insert into btm.student values(102,'harshu',90.00)";//dml
		try {
			Class.forName("org.jsp.demoApp.Test");
			System.out.println("loaded and registered!!!");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=admin");
			System.out.println("connection established java application and database");
			stmt=con.createStatement();
			System.out.println("platform created");
			stmt.executeUpdate(qry);
			System.out.println("record inserted!!!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("closed all the costly resources!!!");
		}
	}

}
