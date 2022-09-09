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
	private RcDTO rcDto;
	public RcDAO() {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="oracle";
		String password="oracle";
		//BoDTO boDto = new BoDTO();
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setRecordInsert(String id, String date, String startT, String endTime, String text) {
		String sql = "Insert into userid_time (id, workoutday, start_time, end_time, record_memo,ptbooked,trainer,bookptdate) values (?,?,?,?,?,'','','')";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, date);
			ps.setString(3, startT);
			ps.setString(4, endTime);
			ps.setString(5, text);
			ps.executeUpdate();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void setRecordUpdate(String id, String date, String startT, String endTime, String text) {
		String sql = "UPDATE USERID_TIME SET ID = ?, start_time=?, end_time=?, record_memo=? where workoutday=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, startT);
			ps.setString(3, endTime);
			ps.setString(4, text);
			ps.setString(5, date);
			ps.executeUpdate();
			} catch (SQLException e) {
			e.printStackTrace();
		}
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
	public String ptDateExiste(String id, String date) {
		String tmp ="";
		String sql = "select BOOKPTDATE from userid_time where id = ? and BOOKPTDATE = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, date);
			rs=ps.executeQuery();
			if(rs.next()){
				 tmp = rs.getString("BOOKPTDATE");
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
			if(rs!=null) {
				rs.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void setRctext(String id, String clikedDate) {
		String tmp ="";
		String sql = "select start_time , end_time , record_memo , point from userid_time where id = ? and workoutday = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, clikedDate);
			rs=ps.executeQuery();
			if(rs.next()){
				 rcDto.setStartTime(rs.getString("start_time"));
				 rcDto.setEndTime(rs.getString("end_time"));
				 rcDto.setRecordMemo(rs.getString("record_memo"));
				 rcDto.setPoint(rs.getString("point"));
			}
			} catch (SQLException e) {
			System.out.println("데이터베이스에 값이 없을수도 있어요A");
			e.printStackTrace();
		}
	}
		
	public void setPttext(String id, String clikedDate) {
		
		String sql2 = "select trainer, ptbooked, point from userid_time where id = ? and BOOKPTDATE = ?";
		
		try {
			ps=con.prepareStatement(sql2);
			ps.setString(1, id);
			ps.setString(2, clikedDate);
			rs=ps.executeQuery();
			if(rs.next()){
				 rcDto.setTrainer(rs.getString("trainer"));
				 rcDto.setPtbooked(rs.getString("ptbooked"));
				 rcDto.setPoint(rs.getString("point"));
			}
			} catch (SQLException e) {
			System.out.println("데이터베이스에 값이 없을수도 있어요B");
			e.printStackTrace();
		}
	}


		
	
	public void setBcDto(RcDTO rcDto) {
		this.rcDto = rcDto;
	}

}
