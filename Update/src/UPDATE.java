import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UPDATE {
	public static void main(String[] args) {
		 Connection con=null;
		 Statement stmt=null;
		 String qry="delete from btm.student where id=3";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=admin");
			stmt=con.createStatement();
			stmt.executeUpdate(qry);
			System.out.println("record is updated");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
