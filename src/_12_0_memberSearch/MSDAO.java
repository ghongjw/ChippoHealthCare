package _12_0_memberSearch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MSDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public MSDAO() {
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

	// 이름으로 정보 가져오는 쿼리
	public void getMemberInfo(String name, MSDTO msDto) {
		String sql = "select * from health_user where name=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (rs.next()) {
				msDto.setName(rs.getString("name"));
				msDto.setGender(rs.getString("gender"));
				msDto.setAge(rs.getInt("age"));
				msDto.setMobile(rs.getString("mobile"));
				msDto.setBranch(rs.getString("branch"));
				msDto.setPtcount(rs.getInt("ptcount"));
				msDto.setExpiryDate(
						rs.getInt("expire_year") + "-" + rs.getInt("expire_month") + "-" + rs.getInt("expire_day"));
			}
		} catch (Exception e) {
			System.out.println("이름 검색해서 회원정보 가져오는 쿼리문 실패");
			e.printStackTrace();
		}
	}

	public ArrayList<MSDTO> getAllData() {
		String sql = "select * from health_user";
		ArrayList<MSDTO> DtoList = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MSDTO allDTO = new MSDTO();
				allDTO.setName(rs.getString("name"));
				allDTO.setGender(rs.getString("gender"));
				allDTO.setAge(rs.getInt("age"));
				allDTO.setMobile(rs.getString("mobile"));
				allDTO.setBranch(rs.getString("branch"));
				allDTO.setPtcount(rs.getInt("ptcount"));
				allDTO.setExpiryDate(
						rs.getInt("expire_year") + "-" + rs.getInt("expire_month") + "-" + rs.getInt("expire_day"));
				DtoList.add(allDTO);
			}
		} catch (Exception e) {
			System.out.println("모든 회원정보 가져오는 쿼리문 실패");
			e.printStackTrace();
		}
		return DtoList;
	}

}
