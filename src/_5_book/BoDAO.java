package _5_book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private BoDTO boDto;
	public BoDAO() {

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
	public ArrayList<String> getTrainerInfo(String branch) {
		String sql = "select name from TRAINER_INFO where point = ?";
		ArrayList<String> trains = new ArrayList<String>();
		try{
			ps=con.prepareStatement(sql);
			ps.setString(1, branch);
			rs=ps.executeQuery();

			while(rs.next()) {
				trains.add(rs.getString("name"));
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}return trains;
	}

	public void getTrainerTimeYesorNot(String trainername, String datepic, BoDTO boDto) {
		// TODO Auto-generated method stub
		String sql = "select t1,t2,t3,t4,t5,t6,t7,t8,t9 from Numtrainer_time where name = ? and to_date=?";
		this.boDto=boDto;

		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,trainername);
			ps.setString(2,datepic);
			rs=ps.executeQuery();

			if(rs.next()) {
				boDto.setT1(rs.getString("T1"));
				boDto.setT2(rs.getString("T2"));
				boDto.setT3(rs.getString("T3"));
				boDto.setT4(rs.getString("T4"));
				boDto.setT5(rs.getString("T5"));
				boDto.setT6(rs.getString("T6"));
				boDto.setT7(rs.getString("T7"));
				boDto.setT8(rs.getString("T8"));
				boDto.setT9(rs.getString("T9"));
			}
		} catch (SQLException e) {
			System.out.println("트레이너 시간 쿼리 문제발생");
			e.printStackTrace();
		}
	}
	public void setTrainerTimeTable(String trainername, String name, String time, String date, String id) {
		
		System.out.println(trainername+","+name+","+time+","+date);
		String sql="";
		if(time.equals("T1")) {
			sql ="Update NUMTRAINER_TIME SET T1 = 'n', T1_USER = ? where name = ? and TO_DATE = ?";
		}else if(time.equals("T2")) {
			sql ="Update NUMTRAINER_TIME SET T2 = 'n', T2_USER = ? where name = ? and TO_DATE = ?";
		}else if(time.equals("T3")) {
			sql ="Update NUMTRAINER_TIME SET T3 = 'n', T3_USER = ? where name = ? and TO_DATE = ?";
		}else if(time.equals("T4")) {
			sql ="Update NUMTRAINER_TIME SET T4 = 'n', T4_USER = ? where name = ? and TO_DATE = ?";
		}else if(time.equals("T5")) {
			sql ="Update NUMTRAINER_TIME SET T5 = 'n', T5_USER = ? where name = ? and TO_DATE = ?";
		}else if(time.equals("T6")) {
			sql ="Update NUMTRAINER_TIME SET T6 = 'n', T6_USER = ? where name = ? and TO_DATE = ?";
		}else if(time.equals("T7")) {
			sql ="Update NUMTRAINER_TIME SET T7 = 'n', T7_USER = ? where name = ? and TO_DATE = ?";
		}else if(time.equals("T8")) {
			sql ="Update NUMTRAINER_TIME SET T8 = 'n', T8_USER = ? where name = ? and TO_DATE = ?";
		}else if(time.equals("T9")) {
			sql ="Update NUMTRAINER_TIME SET T9 = 'n', T9_USER = ? where name = ? and TO_DATE = ?";
		}System.out.println(sql);
		try {ps=con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,trainername);
			ps.setString(3,date);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("트레이너 시간 쿼리 문제발생");
			e.printStackTrace();
		}
		String sql2="";
		if(time.equals("T1")) {
			sql2 ="Update USERID_TIME SET PTBOOKED = 'T1', trainer = ? where id = ? and workoutday = ?";
		}else if(time.equals("T2")) {
			sql2 ="Update USERID_TIME SET PTBOOKED = 'T2', trainer = ? where id = ? and workoutday = ?";
		}else if(time.equals("T3")) {
			sql2 ="Update USERID_TIME SET PTBOOKED = 'T3', trainer = ? where id = ? and workoutday = ?";
		}else if(time.equals("T4")) {
			sql2 ="Update USERID_TIME SET PTBOOKED = 'T4', trainer = ? where id = ? and workoutday = ?";
		}else if(time.equals("T5")) {
			sql2 ="Update USERID_TIME SET PTBOOKED = 'T5', trainer = ? where id = ? and workoutday = ?";
		}else if(time.equals("T6")) {
			sql2 ="Update USERID_TIME SET PTBOOKED = 'T6', trainer = ? where id = ? and workoutday = ?";
		}else if(time.equals("T7")) {
			sql2 ="Update USERID_TIME SET PTBOOKED = 'T7', trainer = ? where id = ? and workoutday = ?";
		}else if(time.equals("T8")) {
			sql2 ="Update USERID_TIME SET PTBOOKED = 'T8', trainer = ? where id = ? and workoutday = ?";
		}else if(time.equals("T9")) {
			sql2 ="Update USERID_TIME SET PTBOOKED = 'T9', trainer = ? where id = ? and workoutday = ?";
		}System.out.println(sql);
		try {ps=con.prepareStatement(sql2);
			ps.setString(1,trainername);
			ps.setString(2,id);
			ps.setString(3,date);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("트레이너 시간 쿼리 문제발생");
			e.printStackTrace();
		}

		
	}
	public String workoutdayinsertDao(String date, String id) {
		String tmp="";
		String sql="select workoutday from userID_time where id = ? and workoutday = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,date);
			rs = ps.executeQuery();
			if(rs.next()) {
			tmp = rs.getString("workoutday");
			}
		} catch (SQLException e) {
			System.out.println("트레이너 시간 쿼리 문제발생 날자 있는지 여부");
			e.printStackTrace();
		}return tmp;
	}
	public void setworkoutdayDao(String date, String id) {
		
		String sql="insert into userID_time (workoutday, id) values (?, ?)";
		try {ps=con.prepareStatement(sql);
			ps.setString(1,date);
			ps.setString(2,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("트레이너 시간 쿼리 문제발생 안서트");
			e.printStackTrace();
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
			e.printStackTrace();
		}

	}
		
	
}



