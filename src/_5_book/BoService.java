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

	
	//2022-08-24
	//public string 


	public void setboDto(BoDTO boDto) {
		this.boDto=boDto;
	}
	public BoDTO getboDto() {
		return boDto;
	}
	public void getTrainerTime(String trainername, String date, BoDTO boDto) {
		// TODO Auto-generated method stub
		this.boDto=boDto;
		boDao.getTrainerTimeYesorNot(trainername,date,boDto);
		
		
	}

}
