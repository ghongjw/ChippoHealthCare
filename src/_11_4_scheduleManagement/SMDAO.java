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

	public void newScheduleInsert(String point, String trainername, String date) {
		String sql = "INSERT INTO NUMTRAINER_TIME(name,point,to_date,t1,t2,t3,t4,t5,t6,t7,t8,t9,t1_user,t2_user,t3_user,t4_user,t5_user,t6_user,t7_user,t8_user,t9_user) VALUES(?,?,?, 'y','y','y',  'y','y','y',  'y','y','y', ' ',' ',' ',' ',' ',' ',' ',' ',' ')";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, trainername);
			ps.setString(2, point);
			ps.setString(3, date);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("새로운 스케줄 생성하는 쿼리문 실패");
			e.printStackTrace();
		}
	}

	public ArrayList<String> getTrainerInfo(String point) {
		String sql = "select name from trainer_info where point = ?";
		ArrayList<String> trainers = new ArrayList<String>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, point);
			rs = ps.executeQuery();
			while (rs.next()) {
				trainers.add(rs.getString("name"));
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("트레이너 이름들 리스트에 담는 쿼리문 실패");
			e.printStackTrace();
		}
		return trainers;
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

	// PT예약 가능여부 Y or N 반환하는 쿼리
	public void getYesNo(String point, String trainername, String date, SMDTO tmDto) {
		String sql = "select t1,t2,t3,t4,t5,t6,t7,t8,t9 from Numtrainer_time WHERE point = ? AND name = ? AND to_date = ?";
		this.tmDto = tmDto;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, point);
			ps.setString(2, trainername);
			ps.setString(3, date);
			rs = ps.executeQuery();
			if (rs.next()) {
				tmDto.setT1(rs.getString("T1"));
				tmDto.setT2(rs.getString("T2"));
				tmDto.setT3(rs.getString("T3"));
				tmDto.setT4(rs.getString("T4"));
				tmDto.setT5(rs.getString("T5"));
				tmDto.setT6(rs.getString("T6"));
				tmDto.setT7(rs.getString("T7"));
				tmDto.setT8(rs.getString("T8"));
				tmDto.setT9(rs.getString("T9"));
			}
		} catch (SQLException e) {
			System.out.println("yes or no 쿼리문 실패");
			e.printStackTrace();
		}
	}

	// 지워도 되는지 나중에 확인 후 지워도 됨 count메서드 사용 안한걸로 기억함(son)
	public int count(String point, String trainername, String date, SMDTO tmDto) {
		String sql = "select count(t1_user) from Numtrainer_time WHERE point = ? AND name = ? AND to_date = ?";
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, point);
			ps.setString(2, trainername);
			ps.setString(3, date);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
				System.out.println("count : " + count);
			}
		} catch (SQLException e) {
			System.out.println("count 쿼리문 실패");
			e.printStackTrace();
		}
		return count;
	}

	public void getMatchMember(String point, String trainername, String date, SMDTO tmDto) {
		String sql = "select t1_user,t2_user,t3_user,t4_user,t5_user,t6_user,t7_user,t8_user,t9_user from Numtrainer_time WHERE point = ? AND name = ? AND to_date = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, point);
			ps.setString(2, trainername);
			ps.setString(3, date);
			rs = ps.executeQuery();
			if (rs.next()) {
				tmDto.setT1_user(rs.getString("T1_user"));
				tmDto.setT2_user(rs.getString("T2_user"));
				tmDto.setT3_user(rs.getString("T3_user"));
				tmDto.setT4_user(rs.getString("T4_user"));
				tmDto.setT5_user(rs.getString("T5_user"));
				tmDto.setT6_user(rs.getString("T6_user"));
				tmDto.setT7_user(rs.getString("T7_user"));
				tmDto.setT8_user(rs.getString("T8_user"));
				tmDto.setT9_user(rs.getString("T9_user"));
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

	// 트레이너 info table 삭제하는 쿼리
	public void deleteInfo(String point, String trainername) {
		String sql = "delete from trainer_info WHERE point = ? AND name = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, point);
			ps.setString(2, trainername);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("트레이너 info table 삭제하는 쿼리문 실패");
			e.printStackTrace();
		}
	}

	// 트레이너 time table 삭제하는 쿼리
	public void deleteTime(String point, String trainername) {
		String sql = "delete from Numtrainer_time WHERE point = ? AND name = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, point);
			ps.setString(2, trainername);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("트레이너 time table 삭제하는 쿼리문 실패");
			e.printStackTrace();
		}
	}
}
