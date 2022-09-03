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
	public ArrayList<MSDTO> getMemberInfo(String name) {
		String sql = "select * from health_user where name like ?";
		ArrayList<MSDTO> likeNames = new ArrayList<>();

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				MSDTO addmsDto = new MSDTO();
				addmsDto.setName(rs.getString("name"));
				addmsDto.setGender(rs.getString("gender"));
				addmsDto.setAge(rs.getInt("age"));
				addmsDto.setMobile(rs.getString("mobile"));
				addmsDto.setBranch(rs.getString("branch"));
				addmsDto.setPtcount(rs.getInt("ptcount"));
				addmsDto.setExpiryDate(
						rs.getInt("expire_year") + "-" + rs.getInt("expire_month") + "-" + rs.getInt("expire_day"));
				addmsDto.setPurposse(rs.getString("purpose"));

				likeNames.add(addmsDto);
			}
			return likeNames;

		} catch (Exception e) {
			System.out.println("이름 검색해서 회원정보 가져오는 쿼리문 실패");
			e.printStackTrace();
		}
		return likeNames;
	}

	// tableView 처음에 다 보여주기위한 쿼리
	public ArrayList<MSDTO> getAllData() {
		String sql = "select * from health_user";
		ArrayList<MSDTO> userInfo = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MSDTO userDTO = new MSDTO();
				userDTO.setName(rs.getString("name"));
				userDTO.setGender(rs.getString("gender"));
				userDTO.setAge(rs.getInt("age"));
				userDTO.setMobile(rs.getString("mobile"));
				userDTO.setBranch(rs.getString("branch"));
				userDTO.setPtcount(rs.getInt("ptcount"));
				userDTO.setExpiryDate(
						rs.getInt("expire_year") + "-" + rs.getInt("expire_month") + "-" + rs.getInt("expire_day"));
				userDTO.setPurposse(rs.getString("purpose"));

				userInfo.add(userDTO);
			}
		} catch (Exception e) {
			System.out.println("모든 회원정보 가져오는 쿼리문 실패");
			e.printStackTrace();
		}
		return userInfo;
	}

}
