package _11_1_regTrainer;

import _0_main.CommonService;
import _1_login.LoginDAO;
import _1_login.LoginDTO;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RTService {
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
		rtDao.insert(rt);

		rtDao.disconnection();
		CommonService.msg("등록 완료");

	}

}
