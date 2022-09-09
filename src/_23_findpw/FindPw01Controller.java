package _23_findpw;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.Opener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FindPw01Controller implements Initializable {
	@FXML
	private Label selecklabel;

	private FindPWService findPwService;
	private Opener opener;
	private FindPwDTO findPwDTO;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void confirmNumCheck() {

	}

	public void setfpService(FindPWService findPwService) {
		this.findPwService = findPwService;
		selecklabel.setText(findPwService.getPw());
	}

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	public void changePw() {
		opener.userInfoUpdateOpen();
	}
	public void login() {
		opener.Login();
	}

	public void backProc() {
		opener.Login();
	}
}
