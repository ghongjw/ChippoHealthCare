package _11_4_scheduleManagement;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class SMService {
	private SMDAO smDao;
	private SMDTO smDto;
	private String[] PTmembersId2;
	private int PTcount;
	private String[] PTmembersName = { "", "", "", "", "", "", "", "", "" };

	public SMService() {
		smDao = new SMDAO();
	}

	public void setsmDto(SMDTO smDto) {
		this.smDto = smDto;
	}

	// PT예약된 회원 이름 DB에서 가져오는 메서드
	public String[] getMatchMemeber(String point, String trainername, String date, SMDTO smDto) {
		smDao.getMatchMember(point, trainername, date, smDto);
		String[] PTmembersId = { smDto.getT1_user(), smDto.getT2_user(), smDto.getT3_user(), smDto.getT4_user(),
				smDto.getT5_user(), smDto.getT6_user(), smDto.getT7_user(), smDto.getT8_user(), smDto.getT9_user() };

//		 PTmembersId에 뭐 담겼는지
//		for (int i = 0; i < PTmembersId.length; i++) {
//			System.out.println(PTmembersId[i]);
//		}
//		System.out.println("위는 id");

		this.PTmembersId2 = PTmembersId;
//		for (int i = 0; i < this.PTmembersId2.length; i++) {
//			System.out.println(this.PTmembersId2[i]);
//		}
//		System.out.println("위는 this.PTmembersId");

		for (int i = 0; i < PTmembersId.length; i++) {
			PTmembersName[i] = smDao.getName(PTmembersId[i]);
		}

//		for (int i = 0; i < PTmembersName.length; i++) {
//			System.out.println(PTmembersName[i]);
//		}
//		System.out.println("위는 name 2");

		return PTmembersName;
	}

	public String[] getIdmembers() {
//		for (int i = 0; i < PTmembersId2.length; i++) {
//			System.out.println("getIdmembers메서드(PTmembersId) : " + PTmembersId2[i]);
//		}
		return PTmembersId2;

	}

	// DB에 스케줄 유무 확인하는 메서드
	public boolean ScheduleEmpty(String point, String trainername, String date, SMDTO tmDto) {
		smDao.ScheduleEmpty(point, trainername, date, tmDto);
		if (tmDto.getDBempty() == null) {
//			System.out.println("비어있음");
			return false;
		} else {
//			System.out.println("들어있음");
			return true;
		}
	}

	public void PTcancel(CheckBox time, String point, String trainername, String date) {
		smDao.PTcancel(time, point, trainername, date);
		smDao.PTcancelUserUpdate(time, point, trainername, date);
	}

	public void rest(CheckBox time, String point, String trainername, String date) {
		smDao.rest(time, point, trainername, date);
	}

	public void PTcountReturn(String membersId) {
		// PTcount[]에 개인 pt카운트들 담김
		// test
//		System.out.println("id : " + membersId);
		PTcount = smDao.currentPTcount(membersId);
//		System.out.println("현재 카운트 : " + PTcount); // 0 나오는중
		smDao.PTcountReturn(PTcount, membersId);
	}

}
