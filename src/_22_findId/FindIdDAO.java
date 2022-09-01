package _22_findId;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindIdDAO {
		private Connection con;
		private PreparedStatement ps;
		private ResultSet rs;
		
		public FindIdDAO() {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "oracle";
			String password = "oracle";
			
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				con = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		public void disconnection() {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
