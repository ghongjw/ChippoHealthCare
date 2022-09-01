package _7_inbodySelect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InbodyDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

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

	public InbodyDTO selectdate(String date) {

		String sql = "SELECT * FROM inbody where date=?";
		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, date);
			rs = ps.executeQuery();
			if (rs.next()) {
				InbodyDTO in = new InbodyDTO();
				in.setAge(rs.getString("age"));
				in.setHeight(rs.getString("height"));
				in.setWeight(rs.getString("weight"));
				in.setMusle(rs.getString("misle"));
				in.setPat(rs.getString("pat"));
				in.setPatper(rs.getString("patper"));
				in.setBmi(rs.getString("bmi"));

				return in;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<InbodyDTO> getdate() {
		String sql = "SELECT * FROM inbody WHERE ID = ?";
		ArrayList<InbodyDTO> inbodys = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, 1);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				InbodyDTO inbody = new InbodyDTO();
				inbody.setDate(rs.getString("date"));
				inbodys.add(inbody);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inbodys;

	}

}
