package _3_UserMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UMDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private UMDTO umDto;
	public UMDAO() {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="JOOWON";
		String password="JOOWON";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public UMDTO lastday(UMDTO umDto) {
		this.umDto = umDto;
		String sql="select expire_year,expire_month,expire_day from health_user where id = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, umDto.getId());
			rs=ps.executeQuery();
			if(rs.next()) {
				umDto.setExpire_year(rs.getInt("expire_year"));				
				umDto.setExpire_month(rs.getInt("expire_month"));
				umDto.setExpire_day(rs.getInt("expire_day"));
				
				}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("expire_date 쿼리에 문제가 있습니다");
		}return umDto;
	}
	public int PTCount(String userId) {
		int ptc=0;
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
