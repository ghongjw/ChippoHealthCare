package _8_1_UserInfoUpdateB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UibDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
public UibDAO() {
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

	public void update(UibDTO userinfo) {
		
		String sql = "UPDATE health_user SET pw=?,email=?,moblie=?, address=?, gender=?, branch=? WHERE id=?";
		
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, userinfo.getPw());
			ps.setString(2, userinfo.getEmail());
			ps.setString(3, userinfo.getPhone());
			ps.setString(4, userinfo.getAddress());
			ps.setString(5, userinfo.getGender());
			ps.setString(6, userinfo.getPoint());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("회원정보 등록 실패");
			e.printStackTrace();
		}
		
	}

	public void disconnection() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

