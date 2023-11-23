package org.jsp.fetchApp;
import java.sql.*;
import java.util.*;

public class FetchingUsingPlaceholder {
	public static void main(String[] args) {
		System.out.println("enter id");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		Connection con=null;
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    String qry="select * from btm.student where id=?";
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	System.out.println("load and registerd");
	    	con=DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=admin");
	    	System.out.println("connecton established");
	    	pstmt=con.prepareStatement(qry);
	    	System.out.println("platform created");
	    	pstmt.setInt(1,id);
	    	rs=pstmt.executeQuery();
	    	if(rs.next()) {
	    		String nm=rs.getString(2);
	    		Double perc=rs.getDouble(3);
	    		String un=rs.getString(4);
	    		System.out.println("name:"+nm);
	    		System.out.println("perc:"+perc);
	    		System.out.println("username:"+un);
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
