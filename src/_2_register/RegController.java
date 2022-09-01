package _2_register;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.CommonService;
import _0_main.Opener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class RegController implements Initializable {
	@FXML
	private Button back;
	@FXML
	private TextField idtextField;
	@FXML
	private Button idcheck;
	@FXML
	private TextField TextFieldpw;
	@FXML
	private TextField TextFieldconfirm;
	@FXML
	private TextField TextFieldname;
	@FXML
	private TextField TextFieldaddress;
	@FXML
	private TextField TextFieldemail;
	@FXML
	private TextField TextFieldmobile;
	@FXML
	private TextField randomNum;
	@FXML
	private RadioButton womanRadio;
	@FXML
	private RadioButton manRadio;
	@FXML
	private Button confirmNumberButton;
	@FXML
	private Button numCheckProc;
	@FXML
	private ComboBox<String> branchCombo;
	@FXML
	private Button regButton;

	private String id, pw, confirmpw, name, address, email, mobile, confirmNum, gender;

	private Parent Register;
	private RegService regService;
	private Opener opener;

	public void setRegister(Parent Register) {

		this.Register = Register;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		regService = new RegService();

	}

	public void regBackProc() {
		CommonService.windowsClose(Register);
	}

	public void idOverlapProc() {
		id = idtextField.getText();
		regService.checkid(id);

	}

	public void certificationNumProc() {
		CommonService.msg("373737");
	}

	public void numCheckProc() {
		if (true) {
			CommonService.msg("인증되었습니다.");
		} else {
			CommonService.msg("인증번호를 다시 확인해주세요.");
		}
	}

	public void regProc() {

//		regService.regProc(Register);
//		CommonService.windowsClose(Register);
//		CommonService.msg("취뽀회원이 되신걸 진심으로 환영합니다.");

	}

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	public void input() {
		id = idtextField.getText();
		pw = TextFieldpw.getText();
		confirmpw = TextFieldconfirm.getText();
		address = TextFieldaddress.getText();
		name = TextFieldname.getText();
		email = TextFieldemail.getText();
		mobile = TextFieldmobile.getText();
		// confirmNum = TextFieldrandomNum.getText();
		if (manRadio.isSelected()) {
			gender = "man";
		}
		if (womanRadio.isSelected()) {
			gender = "woman";
		}
	}

}
