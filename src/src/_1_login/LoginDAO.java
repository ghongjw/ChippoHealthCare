package _1_login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	LoginDTO loginDto;

	public LoginDAO() {
		loginDto = new LoginDTO();
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

	public boolean selectIdInfo(String inputId, String inputPw) {
		System.out.println("userid : " + inputId);
		System.out.println("userpw : " + inputPw);
		String sql = "select id, pw, name, login, expire_year, expire_month, expire_day from health_user where id=? and pw=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, inputId);
			ps.setString(2, inputPw);
			rs = ps.executeQuery();
			if (rs.next()) {
				loginDto.setId(rs.getString("id"));
				loginDto.setPw(rs.getString("pw"));
				loginDto.setName(rs.getString("name"));
				loginDto.setLogin(rs.getString("login"));
				loginDto.setExpireYear(rs.getString("expire_year"));
				loginDto.setExpireMonth(rs.getString("expire_month"));
				loginDto.setExpireDay(rs.getString("expire_day"));
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그인 쿼리 에러 발생");
		}
		return false;

	}

	public void setLogedIn(String inputId) {
		String sql = "update health_user set login = 'y' where id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, inputId);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그인 쿼리 에러 발생");
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

	public LoginDTO getLoginDto() {
		return loginDto;
	}

}
