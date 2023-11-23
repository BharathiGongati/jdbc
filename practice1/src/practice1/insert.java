package practice1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insert {
    public static void main(String[] args) {
    	Connection con=null;
    	Statement stmt=null;
    	String qry="insert into btm.student values(3,'bharu',80.00)";
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=admin");
			stmt=con.createStatement();
			stmt.executeUpdate(qry);
			System.out.println("record inserted");
            			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
