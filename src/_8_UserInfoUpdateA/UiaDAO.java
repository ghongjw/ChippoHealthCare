package _8_UserInfoUpdateA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	public UiaDTO passwordimport(String password, String staticId) {
		String sql = "SELECT * FROM health_user where id=? and pw=? ";
		UiaDTO ui = new UiaDTO();
		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, staticId);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {

				ui.setPw(rs.getString("pw"));

				return ui;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ui.setPw("");
		return ui;
	}

}
