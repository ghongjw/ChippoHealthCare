package _2_register;

import _0_main.CommonService;
import javafx.scene.Parent;

public class RegService {
	RegDAO regDao = new RegDAO();

	public void regProc(Parent Register) {

	}

	public void checkid(String id) {
		int check = 0;
		if (regDao.checkid(id) == 0) {
			CommonService.msg("사용 가능한 아이디입니다.");
		} else {
			CommonService.msg("사용 못 하는 아이디입니다.");
		}

	}

}
