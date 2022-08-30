package _6_Record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import _5_book.BoDTO;

public class RcDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private RcDTO bcDto=new RcDTO();;
	public RcDAO() {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="JOOWON";
		String password="JOOWON";
		//BoDTO boDto = new BoDTO();

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setRecordInsert(String id, String date, String startT, String endTime, String text) {
		
	}
	public void setRecordUpdate(String id, String date, String startT, String endTime, String text) {
		
	}
	
	public String dateExiste(String id, String date) {
		String tmp ="";
		String sql = "select workoutday from userid_time where id = ? and workoutday = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, date);
			rs=ps.executeQuery();
			if(rs.next()){
				 tmp = rs.getString("workoutday");
			}
			} catch (SQLException e) {
			e.printStackTrace();
		}return tmp;
		
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