package org.jsp.fetchApp;

import java.sql.*;


public class Fetching {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		String qry="select * from btm.student";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=admin");
			stmt=con.createStatement();
			rs=stmt.executeQuery(qry);
			
			while(rs.next()) {
				int id=rs.getInt(1);
				String nm=rs.getString(2);
				Double prc=rs.getDouble(3);
				System.out.println(id+" "+nm+" "+prc);
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}
