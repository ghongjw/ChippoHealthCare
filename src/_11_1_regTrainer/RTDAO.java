package _11_1_regTrainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RTDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public RTDAO() {
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

	public void insert(RTDTO reg) {
		//사진은 아직 DB에 안 넣음
		String sql = "INSERT INTO trainer_info VALUES(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, reg.getNum());
			ps.setString(2, reg.getName());
			ps.setString(3, reg.getGender());
			ps.setString(4, reg.getAge());
			ps.setString(5, reg.getSpec());
			ps.setString(6, reg.getPoint());
			ps.executeUpdate();
		} catch (Exception e) {
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
