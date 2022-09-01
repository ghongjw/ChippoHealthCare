package _11_1_regTrainer;

import java.util.ArrayList;

import _0_main.CommonService;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RTService extends _2weeks {

	private RTDAO rtDao;

	public RTService() {
		rtDao = new RTDAO();
	}

	public void regProc(TextField name, TextField age, RadioButton man, RadioButton woman, TextArea spec,
			ComboBox<String> regPoint) {
		// rt(DTO)에 입력한 데이터들 set
		RTDTO rt = new RTDTO();
		rt.setName(name.getText());
		rt.setAge(age.getText());
		rt.setSpec(spec.getText());
		rt.setPoint(regPoint.getValue()); // fx:id와 이름이 같아야함(java.lang.NullPointerException)

		if (man.isSelected())
			rt.setGender("남");
		else if (woman.isSelected())
			rt.setGender("여");

//		 아이디 중복 검증
//		LoginDAO loginDao = new LoginDAO();
//		LoginDTO loginDto = loginDao.selectId(reg.getId());
//		loginDao.disconnection();
//		if (loginDto != null) {
//			CommonService.msg("아이디가 사용 중 입니다.");
//			return;
//		}
//
//		if (pw.getText().equals(confirm.getText()) == false) {
//			CommonService.msg("입력한 비밀번호가 다릅니다.");
//			return;
//		}

		// 회원 가입
		rtDao.insertTrainerInfo(rt);

		ArrayList weeks2 = (get2weeks()); // 2주 날짜들 담긴 리스트
		// 14일의 스케줄표를 만들기 위한 for문
		for (int i = 0; i < weeks2.size(); i++) {
			String date = (String) weeks2.get(i);
			rtDao.insertTrainertime(date, rt);
		}

		rtDao.disconnection();
		CommonService.msg("등록 완료");

	}

}
