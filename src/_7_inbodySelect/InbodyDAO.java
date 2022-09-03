package _7_inbodySelect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import _3_UserMain.UMController;

public class InbodyDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	public InbodyDTO inbodydto;
	
	
	public InbodyDAO() {

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

	public InbodyDTO selectdate(String date, String id) {
		String sql = "SELECT age, height, weight, musle, fat, fatper, bmi FROM inbody where date=? and id=?";
		InbodyDTO in = new InbodyDTO();
		
		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, date);
			ps.setString(2, id);
//			at _7_inbodySelect.InbodyDAO.selectdate(InbodyDAO.java:46)
			rs = ps.executeQuery(); // 여기서 에러뜸(쿼리 실행을 못하는 중...)
			if (rs.next()) {
				in.setAge(rs.getString("age"));
				in.setHeight(rs.getString("height"));
				in.setWeight(rs.getString("weight"));
				in.setMusle(rs.getString("musle"));
				in.setFat(rs.getString("fat"));
				in.setFatper(rs.getString("fatper"));
				in.setBmi(rs.getString("bmi"));
				in.setId(UMController.staticId);
				return in;
			}
		} catch (SQLException e) {
			System.out.println("인바디 정보 가져오는 쿼리 실패");
			e.printStackTrace();
		}
		return in;
	}

	public ArrayList<InbodyDTO> getdate() {
		String sql = "SELECT * FROM inbody WHERE ID = ?";
		ArrayList<InbodyDTO> inbodys = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, UMController.staticId); 
			rs = ps.executeQuery();
			
			while(rs.next()) {
				InbodyDTO inbody = new InbodyDTO();
				inbody.setDate(rs.getString("date"));
				
				inbodys.add(inbody);
				
			}
		} catch (SQLException e) {
			System.out.println("getdate 해오는 쿼리 실패");
			e.printStackTrace();
		}
		return inbodys;

	}

}
