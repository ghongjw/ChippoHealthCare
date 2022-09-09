package _11_4_scheduleManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import _11_1_regTrainer.RTDTO;
import javafx.scene.control.CheckBox;

public class SMDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private SMDTO tmDto;

	public SMDAO() {
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

	public void setYes(String point, String trainername, String date, String time) {
		String sql = "";
		if (time.equals("t1")) {
			sql = "UPDATE NUMTRAINER_TIME SET t1= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.equals("t2")) {
			sql = "UPDATE NUMTRAINER_TIME SET t2= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.equals("t3")) {
			sql = "UPDATE NUMTRAINER_TIME SET t3= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.equals("t4")) {
			sql = "UPDATE NUMTRAINER_TIME SET t4= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.equals("t5")) {
			sql = "UPDATE NUMTRAINER_TIME SET t5= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.equals("t6")) {
			sql = "UPDATE NUMTRAINER_TIME SET t6= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.equals("t7")) {
			sql = "UPDATE NUMTRAINER_TIME SET t7= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.equals("t8")) {
			sql = "UPDATE NUMTRAINER_TIME SET t8= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.equals("t9")) {
			sql = "UPDATE NUMTRAINER_TIME SET t9= ? WHERE point = ? AND name = ? AND to_date = ?";
		}
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "y");
			ps.setString(2, point);
			ps.setString(3, trainername);
			ps.setString(4, date);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("yes 실패");
			e.printStackTrace();
		}
	}

	public void setNo(String point, String trainername, String date, String time) {
		String sql = "";
		if (time.equals("t1")) {
			sql = "UPDATE NUMTRAINER_TIME SET t1= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.equals("t2")) {
			sql = "UPDATE NUMTRAINER_TIME SET t2= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.equals("t3")) {
			sql = "UPDATE NUMTRAINER_TIME SET t3= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.equals("t4")) {
			sql = "UPDATE NUMTRAINER_TIME SET t4= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.equals("t5")) {
			sql = "UPDATE NUMTRAINER_TIME SET t5= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.equals("t6")) {
			sql = "UPDATE NUMTRAINER_TIME SET t6= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.equals("t7")) {
			sql = "UPDATE NUMTRAINER_TIME SET t7= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.equals("t8")) {
			sql = "UPDATE NUMTRAINER_TIME SET t8= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.equals("t9")) {
			sql = "UPDATE NUMTRAINER_TIME SET t9= ? WHERE point = ? AND name = ? AND to_date = ?";
		}
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "n");
			ps.setString(2, point);
			ps.setString(3, trainername);
			ps.setString(4, date);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("no 실패");
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

	// 회원 id가 t[i]_user에 set됨
	public void getMatchMember(String point, String trainername, String date, SMDTO smDto) {
		String sql = "select t1_user,t2_user,t3_user,t4_user,t5_user,t6_user,t7_user,t8_user,t9_user from Numtrainer_time WHERE point = ? AND name = ? AND to_date = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, point);
			ps.setString(2, trainername);
			ps.setString(3, date);
			rs = ps.executeQuery();
			if (rs.next()) {
				smDto.setT1_user(rs.getString("T1_user"));
				smDto.setT2_user(rs.getString("T2_user"));
				smDto.setT3_user(rs.getString("T3_user"));
				smDto.setT4_user(rs.getString("T4_user"));
				smDto.setT5_user(rs.getString("T5_user"));
				smDto.setT6_user(rs.getString("T6_user"));
				smDto.setT7_user(rs.getString("T7_user"));
				smDto.setT8_user(rs.getString("T8_user"));
				smDto.setT9_user(rs.getString("T9_user"));
			}
		} catch (SQLException e) {
			System.out.println("PT예약된 회원 이름 가져오는 쿼리문 실패");
			e.printStackTrace();
		}
	}

	public void ScheduleEmpty(String point, String trainername, String date, SMDTO tmDto) {
		String sql = "select point from Numtrainer_time WHERE point = ? AND name = ? AND to_date = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, point);
			ps.setString(2, trainername);
			ps.setString(3, date);
			rs = ps.executeQuery();
			if (rs.next()) {
				tmDto.setDBempty(rs.getString("point"));
			}
		} catch (SQLException e) {
			System.out.println("DB에 스케줄 있는지 여부 확인 쿼리문 실패");
			e.printStackTrace();
		}
	}

	public void PTcancel(CheckBox time, String point, String trainername, String date) {
		String sql = "";
		if (time.toString().substring(41).replace("'", "").equals("07:00")) {
			sql = "UPDATE NUMTRAINER_TIME SET t1= ? , t1_user= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("09:00")) {
			sql = "UPDATE NUMTRAINER_TIME SET t2= ? , t2_user= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("11:00")) {
			sql = "UPDATE NUMTRAINER_TIME SET t3= ? , t3_user= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("13:00")) {
			sql = "UPDATE NUMTRAINER_TIME SET t4= ? , t4_user= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("15:00")) {
			sql = "UPDATE NUMTRAINER_TIME SET t5= ? , t5_user= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("17:00")) {
			sql = "UPDATE NUMTRAINER_TIME SET t6= ? , t6_user= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("19:00")) {
			sql = "UPDATE NUMTRAINER_TIME SET t7= ? , t7_user= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("21:00")) {
			sql = "UPDATE NUMTRAINER_TIME SET t8= ? , t8_user= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("23:00")) {
			sql = "UPDATE NUMTRAINER_TIME SET t9= ? , t9_user= ? WHERE point = ? AND name = ? AND to_date = ?";
		}
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "y");
			ps.setString(2, " ");
			ps.setString(3, point);
			ps.setString(4, trainername);
			ps.setString(5, date);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("PT취소하는 쿼리 실패");
			e.printStackTrace();
		}
	}

	public void PTcancelUserUpdate(CheckBox time, String point, String trainername, String date) {
		String sql = "";
		if (time.toString().substring(41).replace("'", "").equals("07:00")) {
			sql = "delete from USERID_TIME WHERE point = ? AND trainer = ? AND bookptdate = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("09:00")) {
			sql = "delete from USERID_TIME WHERE point = ? AND trainer = ? AND bookptdate = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("11:00")) {
			sql = "delete from USERID_TIME WHERE point = ? AND trainer = ? AND bookptdate = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("13:00")) {
			sql = "delete from USERID_TIME WHERE point = ? AND trainer = ? AND bookptdate = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("15:00")) {
			sql = "delete from USERID_TIME WHERE point = ? AND trainer = ? AND bookptdate = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("17:00")) {
			sql = "delete from USERID_TIME WHERE point = ? AND trainer = ? AND bookptdate = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("19:00")) {
			sql = "delete from USERID_TIME WHERE point = ? AND trainer = ? AND bookptdate = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("21:00")) {
			sql = "delete from USERID_TIME WHERE point = ? AND trainer = ? AND bookptdate = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("23:00")) {
			sql = "delete from USERID_TIME WHERE point = ? AND trainer = ? AND bookptdate = ?";
		}
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, point);
			ps.setString(2, trainername);
			ps.setString(3, date);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("PT취소 회원DB 업뎃하는 쿼리 실패");
			e.printStackTrace();
		}
	}

	public void rest(CheckBox time, String point, String trainername, String date) {
		String sql = "";
		System.out.println("rest dao");
		if (time.toString().substring(41).replace("'", "").equals("07:00")) {
			sql = "UPDATE NUMTRAINER_TIME SET t1= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("09:00")) {
			sql = "UPDATE NUMTRAINER_TIME SET t2= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("11:00")) {
			sql = "UPDATE NUMTRAINER_TIME SET t3= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("13:00")) {
			sql = "UPDATE NUMTRAINER_TIME SET t4= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("15:00")) {
			sql = "UPDATE NUMTRAINER_TIME SET t5= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("17:00")) {
			sql = "UPDATE NUMTRAINER_TIME SET t6= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("19:00")) {
			sql = "UPDATE NUMTRAINER_TIME SET t7= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("21:00")) {
			sql = "UPDATE NUMTRAINER_TIME SET t8= ? WHERE point = ? AND name = ? AND to_date = ?";
		} else if (time.toString().substring(41).replace("'", "").equals("23:00")) {
			sql = "UPDATE NUMTRAINER_TIME SET t9= ? WHERE point = ? AND name = ? AND to_date = ?";
		}
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "n");
			ps.setString(2, point);
			ps.setString(3, trainername);
			ps.setString(4, date);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("휴무 쿼리 실패");
			e.printStackTrace();
		}
	}

	public String getName(String id) {
		String sql = "SELECT name FROM health_user WHERE id =?";
		String name = "";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				name = rs.getString("name");
				return name;
			}
		} catch (SQLException e) {
			System.out.println("PT매치된 id를 이름으로 바꾸는 쿼리문 실패");
			e.printStackTrace();
		}
		return name = " ";
	}

	public void PTcountReturn(int PTcount, String membersId) {
		String sql = "UPDATE health_user set ptcount=? where id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, PTcount + 1);
			ps.setString(2, membersId);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("PTcount 올려주는 쿼리문 실패");
			e.printStackTrace();
		}

	}

	public int currentPTcount(String membersId) {
		String sql = "select ptcount from health_user where id = ?";
		int PTcount = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, membersId);
			rs = ps.executeQuery();
			if (rs.next()) {
				PTcount = rs.getInt("ptcount");
			}
		} catch (SQLException e) {
			System.out.println("PTcount 가져오는 쿼리문 실패");
			e.printStackTrace();
		}
		return PTcount;
	}
}
