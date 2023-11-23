package org.jsp.fetchApp;
import java.sql.*;
public class Fetchigmultirecords {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from btm.student";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String nm=rs.getString(2);
				Double perc=rs.getDouble(3);
				String un=rs.getString(4);
				System.out.println(id);
				System.out.println(nm);
				System.out.println(perc);
				System.out.println(un);
				System.out.println("============================");
			}
		}
		catch(ClassNotFoundException|SQLException e) {
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
