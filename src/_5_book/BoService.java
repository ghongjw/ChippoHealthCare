package _5_book;

import java.util.ArrayList;

public class BoService {
	BoDAO boDao = new BoDAO();

	public ArrayList<String> getTrainerInfo(String branch) {
		ArrayList<String> trainers = new ArrayList<String>();
		trainers=boDao.getTrainerInfo(branch);
		
		return trainers;
	}

}
