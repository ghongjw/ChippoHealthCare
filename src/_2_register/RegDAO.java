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
		String sql = "INSERT INTO health_user(id,pw,name,age,gender,address,email,mobile,branch,purpose,login,expire_year,expire_month,expire_day,ptcount)VALUES(?,?,?, ?,?,?, ?,?,?, ?,?,?, ?,?,?)";
		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, reg.getId());
			ps.setString(2, reg.getPw());
			ps.setString(3, reg.getName());
			ps.setString(4, reg.getAge());
			ps.setString(5, reg.getGender());
			ps.setString(6, reg.getAddress());
			ps.setString(7, reg.getEmail());
			ps.setString(8, reg.getMobile());
			ps.setString(9, reg.getBranch());
			ps.setString(10, reg.getPurpose());
			ps.setString(11, "n");
			ps.setInt(12, 0);
			ps.setInt(13, 0);
			ps.setInt(14, 0);
			ps.setInt(15, 0);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//	CREATE TABLE health_user(
//			id varchar2(20),
//			pw varchar2(20),
//			name varchar2(20),
//			age varchar2(10),
//			gender varchar2(10),
//			address varchar2(100),
//			email varchar2(50),
//			mobile varchar2(50),
//			branch varchar2(20),
//			purpose varchar2(100),
//			login varchar2(10),
//			expire_year number,
//			expire_month number,
//			expire_day number,
//			ptCount number
//			);

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
