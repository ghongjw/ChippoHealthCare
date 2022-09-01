package _11_0_TrainManagement;

import java.util.ArrayList;

public class TMService {
	private TMDAO tmDao;
	private TMDTO tmDto;

	public TMService() {
		tmDao = new TMDAO();
	}

	public void settmDto(TMDTO tmDto) {
		this.tmDto = tmDto;
	}

	// 지점선택시 해당 지점에 트레이너들 넣어둔 arrlist
	public ArrayList<String> getTrainerInfo(String point) {
		ArrayList<String> trainers = new ArrayList<String>();
		trainers = tmDao.getTrainerInfo(point);

		return trainers;
	}

	// DAO(YesNo)에서 Y or N 반환받아 yesno에 담아줌
	public String[] getYesNo(String point, String trainername, String date, TMDTO tmDto) {
		tmDao.getYesNo(point, trainername, date, tmDto);
		String[] yesno = { tmDto.getT1(), tmDto.getT2(), tmDto.getT3(), tmDto.getT4(), tmDto.getT5(), tmDto.getT6(),
				tmDto.getT7(), tmDto.getT8(), tmDto.getT9() };

		return yesno;
	}

	// PT예약된 회원 이름 DB에서 가져오는 메서드
	public String[] getMatchMemeber(String point, String trainername, String date, TMDTO tmDto) {
		tmDao.getMatchMember(point, trainername, date, tmDto);
		String[] PTmembers = { tmDto.getT1_user(), tmDto.getT2_user(), tmDto.getT3_user(), tmDto.getT4_user(),
				tmDto.getT5_user(), tmDto.getT6_user(), tmDto.getT7_user(), tmDto.getT8_user(), tmDto.getT9_user() };

		return PTmembers;
	}

	// DB에 스케줄 유무 확인하는 메서드
	public boolean ScheduleEmpty(String point, String trainername, String date, TMDTO tmDto) {
		tmDao.ScheduleEmpty(point, trainername, date, tmDto);
		if (tmDto.getDBempty() == null) {
//			System.out.println("비어있음");
			return false;
		} else {
//			System.out.println("들어있음");
			return true;
		}
	}

	// 새로운 스케줄 만드는 메서드
	public void newScheduleInsert(String point, String trainername, String date) {
		tmDao.newScheduleInsert(point, trainername, date);
	}

}
