package _8_UserInfoUpdateA;

import _0_main.CommonService;
import _3_UserMain.UMController;
import javafx.scene.control.TextField;

public class UiaService {

	private UiaDAO uiadao = new UiaDAO();

	public boolean userinfoproc(String password, String staticId) {

		UiaDTO uiadto = uiadao.passwordimport(password, staticId);

		// 비밀번호 비교
		if (uiadto.getPw().equals(password) == false) {
			return false;
		} else {
			return true;
		}

	}

}
