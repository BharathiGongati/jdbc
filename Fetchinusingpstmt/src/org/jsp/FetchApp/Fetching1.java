package org.jsp.FetchApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Fetching1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id");
		int id=sc.nextInt();

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from btm.student where id=?";
				try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String nm=rs.getString(2);
				Double perc=rs.getDouble(3);
				System.out.println(nm+perc);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
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
