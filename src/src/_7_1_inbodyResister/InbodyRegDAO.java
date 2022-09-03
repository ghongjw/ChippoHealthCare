package _7_1_inbodyResister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InbodyRegDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public InbodyRegDAO() {

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

	public void insert(InbodyRegDTO irDto, String id) {

		String sql = "INSERT INTO inbody VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, irDto.getDates());
			ps.setString(2, irDto.getHeight());
			ps.setString(3, irDto.getAge());
			ps.setString(4, irDto.getWeight());
			ps.setString(5, irDto.getMusle());
			ps.setString(6, irDto.getfat());
			ps.setString(7, irDto.getfatper());
			ps.setString(8, irDto.getBmi());
			ps.setString(9, id); // 로그인된 아이디 가져와야됨
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("인바디 등록 실패");
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
