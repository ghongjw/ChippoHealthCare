package _3_UserMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UMDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public UMDAO() {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="oracle";
		String password="oracle";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}
	public String lastday(String userId) {
		String lastDay;
		String sql="select expire_date from health_user where id = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, userId);
			rs=ps.executeQuery();
			if(rs.next()) {
				lastDay = rs.getString("ptCount");
				}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("PTCount 쿼리에 문제가 있습니다");
		}return lastDay;
	}
	public int PTCount(String userId) {
		int ptc;
		String sql="select ptCount from health_user where id = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, userId);
			rs=ps.executeQuery();
			if(rs.next()) {
				ptc = rs.getInt("ptCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("PTCount 쿼리에 문제가 있습니다");
		}return ptc;
	}

}
