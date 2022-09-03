package _2_register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public RegDAO() {
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

	public void insert(RegDTO reg) {
		String sql = "INSERT INTO health_user VALUES(?,?,?, ?,?,?, ?,?,?, ?,?,?, ?,?,?)";
		try {
			ps = con.prepareStatement(sql);
<<<<<<< HEAD
			ps.setString(1, reg.getId());
			ps.setString(12, reg.getPw());
			ps.setString(10, reg.getName());
			ps.setString(14, reg.getAge());
			ps.setString(13, reg.getGender());
			ps.setString(2, reg.getEmail());
			ps.setString(3, reg.getMobile());
			ps.setString(4, reg.getAddress());
			ps.setString(5, reg.getBranch());
			ps.setString(15, reg.getPurpose());
			ps.setString(11, "n");
			ps.setInt(6, 0);
			ps.setInt(7, 0);
			ps.setInt(8, 0);
			ps.setInt(9, 0);
=======
			ps.setInt(1, reg.getNum());
			ps.setString(2, reg.getId());
			ps.setString(3, reg.getPw());
			ps.setString(4, reg.getEmail());
			ps.setString(5, reg.getMobile());
			ps.setString(6, reg.getAddress());
			ps.setString(7, reg.getBranch());
			ps.setString(8, reg.getPtcount());
			ps.setString(9, "n");
			ps.setInt(10, reg.getExpireyear());
			ps.setInt(11, reg.getExpiremonth());
			ps.setInt(12, reg.getExpireday());
>>>>>>> refs/heads/newB
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("회원가입쪽에서 DB에 insert시키는 쿼리 실패");
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

	public int checkid(String id) {
		String sql = "SELECT count(id) FROM health_user WHERE id=?";
		int check = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) { // 지속적으로 모든 값을 받음
				check = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

}
