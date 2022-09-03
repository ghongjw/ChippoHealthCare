package _2_register;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import _0_main.CommonService;
import _0_main.Opener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Labeled;
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
	private TextField TextFieldage;
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
	private Button confirmNumber;
	@FXML
	private Button numCheckProc;
	@FXML
	private ComboBox<String> branchCombo;
	@FXML
	private Button regButton;
	private String id, pw, confirmpw, name, address, email, mobile, gender, confirmNum, age;

	public String resultNum = "";
	private Parent Register;
	private RegService regService;
	private Opener opener;

	public void setRegister(Parent Register) {
		this.Register = Register;
	}

	public void setOpener(Opener opener) {
		this.opener = opener;
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
		Random random = new Random();
		int createNum = 0;
		String ranNum = "";
		int letter = 6;
		resultNum = "";
		for (int i = 0; i < letter; i++) {
			createNum = random.nextInt(9);
			ranNum = Integer.toString(createNum);
			resultNum += ranNum;
		}
		CommonService.msg("인증번호는" + resultNum + "입니다.");
	}

	public void numCheckProc() {
		confirmNum = randomNum.getText();
		if (resultNum == confirmNum) {
			CommonService.msg("인증되었습니다.");
		} else {
			CommonService.msg("인증번호를 다시 확인해주세요.");
		}
	}

	public void regProc() {
		RegDTO reg = new RegDTO();
		RegDAO regDao = new RegDAO();
		// number 1000부터 구현 해야함 기본값 1000부터 주기!!!
		id = idtextField.getText();
		reg.setId(id);
		pw = TextFieldpw.getText();
		reg.setPw(pw);
		name = TextFieldname.getText();
		reg.setName(name);
		age = TextFieldage.getText();
		reg.setAge(age);
		address = TextFieldaddress.getText();
		reg.setAddress(address);
		email = TextFieldemail.getText();
		reg.setEmail(email);
		mobile = TextFieldmobile.getText();
		reg.setMobile(mobile);
		reg.setBranch(branchCombo.getValue());
		if (manRadio.isSelected()) {
			reg.setGender("man");
		}
		if (womanRadio.isSelected()) {
			reg.setGender("woman");
		}
		regDao.insert(reg);
		regDao.disconnection();
		CommonService.windowsClose(Register);
		CommonService.msg("취뽀회원이 되신걸 진심으로 환영합니다.");
	}
}
