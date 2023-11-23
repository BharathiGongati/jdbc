package org.jsp.loginApp;
import java.sql.*;
import java.util.*;
public class LoginValidation {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name and perc");
		String nm=sc.next();
		Double perc=sc.nextDouble();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select usename from btm.student where name=? and perc=?"; 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			pstmt.setString(1, nm);
			pstmt.setDouble(2,perc);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString(1));
			}
			else {
				System.err.println("no matchin name and password");
			}
			
		}
	    catch(ClassNotFoundException |SQLException e) {
	    	e.printStackTrace();
	    }
		finally {
			if(rs!=null) {
				try {
					rs.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
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
