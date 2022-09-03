package _8_UserInfoUpdateA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import _3_UserMain.UMController;

public class UiaDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public UiaDAO() {

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

	public void passwordimport(String password1) {
		String sql = "SELECT pw FROM health_user where id=?";
		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, UMController.staticId);
			rs = ps.executeQuery();
			if (rs.next()) {

				UiaDTO ui = new UiaDTO();
				ui.setPw(rs.getString("pw"));

				return;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

}
