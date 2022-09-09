package _2_register;

import _0_main.CommonService;
import _0_main.Opener;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RegService {

	RegDAO regDao = new RegDAO();
	//////////////////////////////////////////////////////////////(인증번호 랜덤)
	Opener opener;
	String confirmtest;
	private String reg;
	//////////////////////////////////////////////////////////////(인증번호 랜덤)


	
	public void regProc(Parent Register) {
		
	}
	
	public void checkid(String id) {
		int check=0;
		if(regDao.checkid(id)== 0 ) {
			CommonService.msg("사용 가능한 아이디입니다.");
		} else {
			CommonService.msg("이미 사용중인 아이디입니다.");
		}
	}
	//////////////////////////////////////////////////////////////(인증번호 랜덤)
	public String getconfirmtest() {
		return confirmtest;
	}
	//////////////////////////////////////////////////////////////(인증번호 랜덤)

}
