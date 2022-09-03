package _8_UserInfoUpdateA;

import _0_main.CommonService;
import javafx.scene.control.TextField;

public class UiaService {

	private UiaDAO uiadao = new UiaDAO();

	public void userinfoproc(TextField password) {

		UiaDTO uiadto = new UiaDTO();

		// 비밀번호 비교
		if (uiadto.getPw().equals(password.getText()) == false) {

			CommonService.msg("아이디 또는 비밀번호를 확인 후 다시 입력하세요.");
			return;
		} else {

			uiadto.setPw(password.getText());

		}
	}

}
