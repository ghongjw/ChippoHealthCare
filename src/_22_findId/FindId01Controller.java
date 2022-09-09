package _22_findId;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.Opener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FindId01Controller implements Initializable {
	@FXML
	private Label selecklabel;
	
	private FindIDService findIDService;
	private Opener opener;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	public void setfiService(FindIDService findIdService) {
		this.findIDService=findIdService;
		selecklabel.setText(findIdService.getId());
	}
	public void setOpener(Opener opener) {
		this.opener = opener;
	}
	public void loginButtonproc() {
		opener.Login();
	}

	public void findPwButtonProc() {
		opener.Findpw0Open();
	}

	public void backbuttonproc() {
		opener.Login();
	}
}
