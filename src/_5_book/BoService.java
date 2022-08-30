package _5_book;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javafx.scene.control.DatePicker;

public class BoService {
	private BoDAO boDao = new BoDAO();
	private BoDTO boDto;


	public ArrayList<String> getTrainerInfo(String branch) {
		ArrayList<String> trainers = new ArrayList<String>();
		trainers=boDao.getTrainerInfo(branch);
		
		return trainers;
	}

	public void setboDto(BoDTO boDto) {
		this.boDto=boDto;
	}
	public BoDTO getboDto() {
		return boDto;
	}
	public String[] getTrainerTime(String trainername, String date, BoDTO boDto) {
		// TODO Auto-generated method stub
		this.boDto=boDto;
		boDao.getTrainerTimeYesorNot(trainername,date,boDto);
		String[] times =
			{boDto.getT1(),boDto.getT2(),boDto.getT3(),boDto.getT4(),boDto.getT5(),
					boDto.getT6(),boDto.getT7(),boDto.getT8(),boDto.getT9()};
					
		return times;
	}


	public void bookPtTime(String trainername, String name, String time, String date, String id) {
		boDao.setTrainerTimeTable(trainername,name,time,date,id);
		
	}
	public void workoutdayinsert(String date,String id) {
		String workoutTime = boDao.workoutdayinsertDao(date,id);
		if(workoutTime.equals("")) {
			boDao.setworkoutdayDao(date,id);
		}
	}

}
