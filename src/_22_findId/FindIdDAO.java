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
	public String getIDformname(String name, String moblie) {
		String sql = "select id from health_user where name = ? and mobile = ?";
		String id = "";
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, moblie);
				rs=ps.executeQuery();
				if(rs.next()) {
				id = rs.getString("id");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}return id;
			
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
	public void getid(String name, String moblie) {

	}
}
