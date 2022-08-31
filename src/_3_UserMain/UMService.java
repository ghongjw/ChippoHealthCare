package _3_UserMain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javafx.scene.Parent;
import javafx.scene.control.Label;

public class UMService {
	private UMDAO umDao;
	private String userId;
	private String userName;
	private int todayYear,todayMonth,todayDay;
	private String stryear,strmonth,strday;
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
		String lastday = null;
		int expireYear = umDto.getExpire_year();
		int expireMonth = umDto.getExpire_month();
		int expireDay = umDto.getExpire_day();

		System.out.println("today"+expireYear+todayYear+expireMonth+todayMonth+expireDay+todayDay);
		String eyear= Integer.toString(expireYear);
		String emonth= Integer.toString(expireMonth);
		String eday= Integer.toString(expireDay);

		if(expireYear>todayYear)lastday = "님의 남은 이용기간은"+ eyear+"년" +emonth+"월"+eday+"일"+"입니다.";
		else if(expireYear==todayYear) {
			if(expireMonth>todayMonth)lastday = "님의 남은 이용기간은"+ eyear+"년" +emonth+"월"+eday+"일"+"입니다.";
			else if(expireMonth==todayMonth) {
				if(expireDay>=todayDay)lastday = "님의 남은 이용기간은"+ eyear+"년" +emonth+"월"+eday+"일"+"입니다.";
				else lastday="님! 이용권을 구매해 주세요";
			}else lastday="님! 이용권을 구매해 주세요";
		}else lastday="님! 이용권을 구매해 주세요";
		return lastday;
	}
	private String ayear;
	private String amonth;
	private String aday;
	public ArrayList<Integer> bookedPtDate(String year,String month) {
		//뭐리문에서 like로 부르려 한다
		String monyear="";
		if(month.length()==1) {
			monyear = year+"-0"+month;
		}else if(month.length()==2) {
			monyear = year+"-"+month;
		}
		ArrayList<String> PTDay = umDao.ptbooked(monyear);
		ArrayList<Integer> Ptmon = new ArrayList();
		System.out.println("monyear:" + monyear);
		for(int i = 0; i<PTDay.size();i++) {
			String tmp = PTDay.get(i);
			String[] sp=tmp.split("-");
			Ptmon.add(Integer.parseInt(sp[2]));
		}
		return Ptmon;
	}

		
	
	public String getaday() {
		return aday;
	}
	public void today() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String regDate = sdf.format(date);
		String[] DateSplit = regDate.split("-");
		stryear = DateSplit[0];
		strmonth = DateSplit[1];
		strday = DateSplit[2];

		todayYear=Integer.parseInt(stryear);
		todayMonth=Integer.parseInt(strmonth);
		todayDay=Integer.parseInt(strday);
	}
	public int getTodayYear() {
		return todayYear;
	}

	public int getTodayMonth() {
		return todayMonth;
	}

	public int getTodayDay() {
		return todayDay;
	}
	public String getStryear() {
		return stryear;
	}
	public String getStrmonth() {
		return strmonth;
	}
	public String getStrday() {
		return strday;
	}
	public boolean setlogout(String id) {
		boolean check=false;
		if(umDao.userLogout(id)) {
			check=true;
		}
			return check;
		
	}





}
