package org.jsp.updateApp;
import java.sql.DriverManager;

import java.sql.*;

public class Delete {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String qry="delete from btm.student where id=104";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("load and registered");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=admin");
			System.out.println("connection established");
			stmt=con.createStatement();
			System.out.println("platformcreated");
			stmt.executeUpdate(qry);
			System.out.println("record deleted");
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(stmt!=null) {
				try {
				stmt.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
				con.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
				
		}

		
		
	}

}
