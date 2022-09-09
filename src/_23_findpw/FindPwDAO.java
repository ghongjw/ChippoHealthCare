package _23_findpw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindPwDAO {
		private Connection con;
		private PreparedStatement ps;
		private ResultSet rs;
		
		public FindPwDAO() {
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
		public String getPWformName(String name, String mobile, String id)  {
			String sql = "SELECT pw from health_user WHERE id = ? AND name = ? AND mobile = ?";
			String pw = "";
			System.out.println();
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setString(3, mobile);
				rs=ps.executeQuery();
				if(rs.next()) {
				pw = rs.getString("pw");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}return pw;
		}
		public void getpw(String name, String moblie, String id) {
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
