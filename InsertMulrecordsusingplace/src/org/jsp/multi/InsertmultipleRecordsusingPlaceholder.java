package org.jsp.multi;
import java.sql.*;
import java.util.*;
public class InsertmultipleRecordsusingPlaceholder {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter id,name,perc,usernm");
	int id=sc.nextInt();
	String nm=sc.next();
	Double perc=sc.nextDouble();
	String un=sc.next();
	Connection con=null;
	PreparedStatement pstmt=null;
	String qry="insert into btm.student values(?,?,?,?) ";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=admin");
		pstmt=con.prepareStatement(qry);
		pstmt.setInt(1, id);
		pstmt.setString(2, nm);
		pstmt.setDouble(3,perc);
		pstmt.setString(4, un);
		
		pstmt.executeUpdate();
		System.out.println("record inserted");
		
		
	}
	catch(ClassNotFoundException |SQLException e) {
		e.printStackTrace();
	}
	finally {
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
