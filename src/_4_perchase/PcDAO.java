package _4_perchase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import _3_UserMain.UMDTO;

public class PcDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	public PcDAO() {
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

	public PcDTO getLastDay(String id,PcDTO pcDto) {
		String sql = "select expire_year, expire_month, expire_day, ptCount from health_user where id = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				pcDto.setExpire_year(rs.getInt("expire_year"));
				pcDto.setExpire_month(rs.getInt("expire_month"));
				pcDto.setExpire_day(rs.getInt("expire_day"));
				pcDto.setPtCount(rs.getInt("ptCount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("PTCount A쿼리에 문제가 있습니다");
		}return pcDto;

	}

	public void setLastDay(String id, int expireYear, int expireMonth, int expireDay, int ptCount) {
		String sql = "update health_user set expire_year=?, expire_month=?, expire_day=?, ptCount=? where id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, expireYear);
			ps.setInt(2, expireMonth);
			ps.setInt(3, expireDay);
			ps.setInt(4, ptCount);
			ps.setString(5, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("PTCount B 쿼리에 문제가 있습니다");

		}
	}

	public void disconnection() {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				rs.close();
			}
			if(con!=null) {
				rs.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
