package _3_UserMain;

import javafx.scene.Parent;
import javafx.scene.control.Label;

public class UMService {
	private UMDAO umDao;
	private String userId;
	private String userName;
	private UMController umController;
	private int year,month;
	//유저 메인 실행(이 메서드의 구현은 로그인 이밴트로
	UMDTO umDto;
	public UMService() {
		umDao = new UMDAO();
		umDto=new UMDTO();
	}
	

	public void setId(String userId,String userName) {
		this.userId=userId;
		this.userName=userName;
		umDto.setId(userId);
	}
	//라벨에 아이디값 전송
	public String getId() {
		return userId;
	}
	//라벨에 이름 값 전송
	public String getName() {
		return userName;
	}
	//쿼리문으로 피티카운트 가져오기
	public String getPTCount() {
		String ptc = Integer.toString(umDao.PTCount(userId));
		return ptc;
	}
	//쿼리문으로 헬스이용마지막 날 가져오기
	public String getLastDay() {
		umDao.lastday(umDto);
		int expireYear = umDto.getExpire_year();
		int expireMonth = umDto.getExpire_month();
		int expireDay = umDto.getExpire_day();
		
		String eyear= Integer.toString(expireYear);
		String emonth= Integer.toString(expireMonth);
		String eday= Integer.toString(expireDay);
		
		String lastday = eyear+"년 " +emonth+"월 "+eday+"일";
		
		return lastday;
	}
	private String ayear;
	private String amonth;
	private String aday;
	public void bookedPtDate(String year,String month) {
		//뭐리문에서 like로 부르려 한다
		String monyear = year+"-"+month;
		String a = umDao.ptbooked(monyear);
		System.out.println("monyear:" + monyear);
//		String[] aSplit = a.split("-");
//		ayear = aSplit[0];
//		amonth = aSplit[1];
//		aday = aSplit[2];
		
	}
	public String getaday() {
		return aday;
	}
	
}
