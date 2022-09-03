package _8_UserInfoUpdateA;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.CommonService;
import _0_main.Opener;
import _1_login.LoginDTO;
import _7_1_inbodyResister.InbodyRegService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UiaController implements Initializable {

	@FXML
	private Button confirm;
	@FXML
	private Button back;
	@FXML
	private TextField password;

	private UiaDAO uiadao;
	private UiaService uiaservice;
	private Opener opener;
	private LoginDTO logindto;

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		uiaservice = new UiaService();
	}

	public void confirm() {

		uiaservice.userinfoproc(password);

		CommonService.msg("확인되었습니다.");

		opener.userInfoUpdateOpen();
	}

	public void back() {

		opener.umOpen();

	}

}
