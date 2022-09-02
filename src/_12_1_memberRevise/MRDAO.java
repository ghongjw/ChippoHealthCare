package _12_1_memberRevise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MRDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public MRDAO() {
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

	public void update(MRDTO mrDto) {
		String sql = "UPDATE health_user SET name=?,gender=?,age=?, mobile=?, branch=?, purpose=? , expire_year=?, expire_month=?, expire_day=?,ptcount=? WHERE name=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mrDto.getName());
			ps.setString(2, mrDto.getGender());
			ps.setString(3, mrDto.getAge());
			ps.setString(4, mrDto.getPhone());
			ps.setString(5, mrDto.getBranch());
			ps.setString(6, mrDto.getPurpose());
			ps.setInt(7, mrDto.getExpire_year());
			ps.setInt(8, mrDto.getExpire_month());
			ps.setInt(9, mrDto.getExpire_day());
			ps.setInt(10, mrDto.getPt());
			ps.setString(11, mrDto.getOldName());

			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("회원정보 수정 실패");
			e.printStackTrace();
		}

	}
}
