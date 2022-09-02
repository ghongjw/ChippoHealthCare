package _1_login;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.Opener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
	@FXML
	private TextField id;
	@FXML
	private PasswordField pw;
	private LoginService loginService;
	private Opener opener;
	private String inputId, inputPw;
	private String userId;
	private String userName;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loginService = new LoginService();
	}

	public void loginProc() {
		inputId = id.getText();
		inputPw = pw.getText();
		loginService.loginset(inputId, inputPw, opener);

		id.clear();
		pw.clear();
	}

	public void regProc() {
		opener.agreementOpen();
	}

	public void idpwFind() {
		opener.idpwOpen();
	}

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

}
