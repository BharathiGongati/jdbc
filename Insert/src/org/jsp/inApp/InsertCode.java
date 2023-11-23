package org.jsp.inApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertCode {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String qry="insert into btm.student values(106,'sheela',80.30,'dgh@123')";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("load and registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=admin");
			System.out.println("connection is established");
			stmt=con.createStatement();
			stmt.executeUpdate(qry);
			System.out.println("record is inserted");
			
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
			System.out.println("all the costly resorces are closed");

		}
	}

}
