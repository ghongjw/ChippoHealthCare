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
		String sql = "select t1,t2,t3,t4,t5,t6,t7 from Numtrainer_time where name = ? and to_date=?";
		this.boDto=boDto;
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,trainername);
			ps.setString(2,datepic);
			rs=ps.executeQuery();

			if(rs.next()) {
				boDto.setT1(rs.getString("t1"));
				boDto.setT2(rs.getString("t2"));
				boDto.setT3(rs.getString("t3"));
				boDto.setT4(rs.getString("t4"));
				boDto.setT5(rs.getString("t5"));
				boDto.setT6(rs.getString("t6"));
				boDto.setT7(rs.getString("t7"));
			}
		} catch (SQLException e) {
			System.out.println("트레이너 시간 쿼리 문제발생");
			e.printStackTrace();
		}

	}
}


