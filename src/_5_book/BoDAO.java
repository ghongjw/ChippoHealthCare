package _5_book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<String> getTrainerInfo(String branch) {
		String sql = "select name from Numtrainer_time where branch = ?";
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

}
