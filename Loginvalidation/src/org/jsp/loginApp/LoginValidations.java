package org.jsp.loginApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginValidations {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name and percentage");
		String nm=sc.next();
        Double ps=sc.nextDouble();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select usename from btm.student where name= ? and perc=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			pstmt.setString(1,nm);
			pstmt.setDouble(2, ps);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				 String user=rs.getString(1);
				 System.out.println(user);
			}
			else {
				System.err.println("you entered invalid name percentage");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
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

}
