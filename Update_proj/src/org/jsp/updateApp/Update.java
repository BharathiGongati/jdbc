package org.jsp.updateApp;
import java.sql.*;

public class Update {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String qry="update btm.student set name='mala' where id=106";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("load and registered succesfully");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=admin");
			System.out.println("connection established");
			stmt=con.createStatement();
			System.out.println("platform created");
			stmt.executeUpdate(qry);
			System.out.println("record updated");
			
		}
		catch (ClassNotFoundException | SQLException e) {
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
		}
		}
	}

		

		
	


