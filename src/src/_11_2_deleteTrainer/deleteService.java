package _11_2_deleteTrainer;

import _11_0_TrainManagement.TMDAO;

public class deleteService extends TMDAO {

	// 트레이너 info랑 스케줄표 지우는 메서드
	public void delInfotime(String point, String trainername) {
		deleteInfo(point, trainername);
		deleteTime(point, trainername);
	}

}
