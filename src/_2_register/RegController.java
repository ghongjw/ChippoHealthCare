package _2_register;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

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
	////////////////////////////////////////////////////////////// (인증번호 랜덤)
	@FXML
	private TextField TextFieldconfirm;
	@FXML
	private TextField confirmNum;
	@FXML
	private TextField Mobile;
	////////////////////////////////////////////////////////////// (인증번호 랜덤)
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
	/////////////////////////////////////////////////////////////////// (라디오버튼 추가)
	@FXML
	private RadioButton dietRadio;
	@FXML
	private RadioButton competitionRadio;
	@FXML
	private RadioButton healthRadio;
	/////////////////////////////////////////////////////////////////// (라디오버튼 추가)
	@FXML
	private Button regButton;

	private String id, pw, name, address, email, mobile, gender, age, tmp, tmp1, tmp2;
	public String resultNum = "";
	private Parent Register;
	private RegService regService;
	private Opener opener;
	////////////////////////////////////////////////////////////// (인증번호 랜덤)
	private String confirmtest = "";
	private RegDTO regDTO;
	private String conMobile;

	////////////////////////////////////////////////////////////// (인증번호 랜덤)
	public void setRegister(Parent Register) {
		this.Register = Register;
	}

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		regService = new RegService();
		////////////////////////////////////////////////////////////// (인증번호 랜덤)
		regDTO = new RegDTO();
		////////////////////////////////////////////////////////////// (인증번호 랜덤)
	}

	public void regBackProc() {
		/////////////////////////////////////////////////////////////////// (로그인페이지
		/////////////////////////////////////////////////////////////////// 화면전환)
		opener.Login();
	}

	public void idOverlapProc() {
		id = idtextField.getText();
		regService.checkid(id);
	}

	public void certificationNumProc() {
		////////////////////////////////////////////////////////////// (인증번호 랜덤)
		Random random = new Random();
		int createNum = 0;
		String ranNum = "";
		int letter = 6;
		String resultNum = "";
		for (int i = 0; i < letter; i++) {
			createNum = random.nextInt(9);
			ranNum = Integer.toString(createNum);
			resultNum += ranNum;
			if (!(TextFieldmobile.getText().matches("^\\d{3}-\\d{4}-\\d{4}$"))) {
				CommonService.msg("전화번호의 형식이 올바르지 않습니다. 확인하시고 가입해주세요.");
				TextFieldmobile.clear();
				TextFieldmobile.requestFocus();
				return;
			}

		}
		CommonService.msg("인증번호는" + resultNum + "입니다.");
		tmp1 = resultNum;

	}

	public void numCheckProc() {
		if (randomNum.getText().equals(tmp1) == true) {
			CommonService.msg("인증되었습니다.");
		} else
			CommonService.msg("다시 확인 해 주세요");
	}
	////////////////////////////////////////////////////////////// (인증번호 랜덤)

	public boolean regProc() {
		tmp2 = tmp1;
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
			reg.setGender("남");
		} else if (womanRadio.isSelected()) {
			reg.setGender("여");
		}
		/////////////////////////////////////////////////////////////////// (라디오버튼 추가)
		String tmp = "";
		if (dietRadio.isSelected())
			tmp += "diet  ";
		if (competitionRadio.isSelected())
			tmp += "competition  ";
		if (healthRadio.isSelected())
			tmp += "health  ";
		reg.setPurpose(tmp);
		/////////////////////////////////////////////////////////////////// (라디오버튼 추가)

		////////////////////////////////////////////// (회원가입 제한)//////////////////////

		// 아이디 정규식(영문자 숫자 6~15)
		System.out.println(idtextField.getText().matches("^[a-z0-9]*$"));
		System.out.println(idtextField.getText().length() > 15);
		System.out.println(idtextField.getText().length() < 6);
		if (!(idtextField.getText().matches("^[a-z0-9]*$")) || idtextField.getText().length() > 15
				|| idtextField.getText().length() < 6) {
			CommonService.msg("아이디 형식이 올바르지 않습니다. 확인하시고 가입해주세요.");
			idtextField.clear();
			idtextField.requestFocus();
			return false;
		}
//      //비밀번호 정규식(영문자 숫자 6~15)
		if (!(TextFieldpw.getText().matches("^[a-z0-9]*$")) || TextFieldpw.getText().length() > 15
				|| TextFieldpw.getText().length() < 6) {
			CommonService.msg("비밀번호 형식이 올바르지 않습니다. 확인하시고 가입해주세요.");
			TextFieldpw.clear();
			TextFieldpw.requestFocus();
			return false;
		}
//   //비밀번호 다시 입력 확인
		if (TextFieldpw.getText().equals(TextFieldconfirm.getText()) == false) {
			CommonService.msg("비밀번호가 서로 일치하지 않습니다. 확인하시고 가입해주세요.");
			TextFieldpw.clear();
			TextFieldpw.requestFocus();
			return false;
		}
//      //이름 공란
		if (TextFieldname.getText().isEmpty()) {
			CommonService.msg("이름은 필수 입력입니다. 확인하시고 가입해주세요.");
			TextFieldname.requestFocus();
			return false;
		}
//      //2자이상 8자 이하
		if (TextFieldname.getText().length() < 2 || TextFieldname.getText().length() > 8) {
			CommonService.msg("이름은 두 글자 이상 10자 이하 이어야 입니다. 확인하시고 가입해주세요.");
			TextFieldname.clear();
			TextFieldname.requestFocus();
			return false;
		}
//      //영어 한글만 가능
		if (!(TextFieldname.getText().matches("^[a-zA-Z]*$")) && (!(TextFieldname.getText().matches("^[가-힣]*$")))) {
			CommonService.msg("이름은 영어 및 한글만 가능합니다. 확인하시고 가입해주세요.");
			TextFieldname.clear();
			TextFieldname.requestFocus();
			return false;
		}
//      //나이 공란
		if (TextFieldage.getText().isEmpty()) {
			CommonService.msg("나이는 필수 입력입니다. 확인하시고 가입해주세요.");
			TextFieldage.requestFocus();
			return false;
		}
//      //2자이상 3자 이하
		if (TextFieldage.getText().length() < 2 || TextFieldage.getText().length() > 3) {
			CommonService.msg("나이는 2자리 이상 3자리 이하 이어야 입니다. 확인하시고 가입해주세요.");
			TextFieldage.clear();
			TextFieldage.requestFocus();
			return false;
		}
//      //숫자만 가능
		if (!(TextFieldage.getText().matches("^[0-9]*$"))) {
			CommonService.msg("나이는 숫자만 가능합니다. 확인하시고 가입해주세요.");
			TextFieldage.clear();
			TextFieldage.requestFocus();
			return false;
		}
//      //성별 체크 유무
		if (!(womanRadio.isSelected()) && !(manRadio.isSelected())) {
			CommonService.msg("성별은 필수 선택입니다. 확인하시고 가입해주세요.");
			return false;
		}
//      //주소 공란
		if (TextFieldaddress.getText().isEmpty()) {
			CommonService.msg("주소는 필수 입력입니다. 확인하시고 가입해주세요.");
			TextFieldaddress.requestFocus();
			return false;
		}
//      //6자이상 30자 이하
		if (TextFieldaddress.getText().length() < 6 || TextFieldaddress.getText().length() > 30) {
			CommonService.msg("주소는  6자리 이상 20자리 이하 이어야 입니다. 확인하시고 가입해주세요.");
			TextFieldaddress.clear();
			TextFieldaddress.requestFocus();
			return false;
		}
//      //영어 및 한글과 숫자만 가능
		if (!(TextFieldaddress.getText().matches("^[a-zA-Z0-9가-힣]*$"))) {
			CommonService.msg("주소는 영어 및 한글과 숫자만 가능합니다. 확인하시고 가입해주세요.");
			TextFieldaddress.clear();
			TextFieldaddress.requestFocus();
			return false;
		}
//      //전화번호 정규식(010-0000-0000)  
		if (!(TextFieldmobile.getText().matches("^\\d{3}-\\d{4}-\\d{4}$"))) {
			CommonService.msg("전화번호의 형식이 올바르지 않습니다. 확인하시고 가입해주세요.");
			TextFieldmobile.clear();
			TextFieldmobile.requestFocus();
			return false;
		}
//      //이메일 정규식(대소문자 및 숫자 @ 소문자  . 소문자)  
		if (!(TextFieldemail.getText().matches("^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$"))) {
			CommonService.msg("이메일의 형식이 올바르지 않습니다. 확인하시고 가입해주세요.");
			TextFieldemail.clear();
			TextFieldemail.requestFocus();
			return false;
		}
//      //전화번호 인증 공란
		if (randomNum.getText().isEmpty()) {
			CommonService.msg("전화번호 인증은 필수입니다. 확인하시고 가입해주세요.");
			randomNum.requestFocus();
			return false;
		}
//      //6자리 고정
		if (!(randomNum.getText().length() == 6)) {
			CommonService.msg("인증번호가 잘못되었습니다. 확인하시고 가입해주세요.");
			randomNum.clear();
			randomNum.requestFocus();
			return false;
		}
//      // 숫자만 가능
		if (!randomNum.getText().matches("^[0-9]*$")) {
			CommonService.msg("인증번호의 형식이 올바르지 않습니다. 확인하시고 가입해주세요.");
			randomNum.clear();
			randomNum.requestFocus();
			return false;
		}
		// 인증확인
		if (randomNum.getText().equals(tmp2) == true) {
//			CommonService.msg("인증되었습니다.");
		} else {
			CommonService.msg("다시 확인 해 주세요");
			randomNum.clear();
			randomNum.requestFocus();
			return false;
		}

//      //운동목적 체크 유무
		if (!(dietRadio.isSelected()) && !(competitionRadio.isSelected()) && !(healthRadio.isSelected())) {
			CommonService.msg("운동목적은 한개 이상 필수 선택입니다. 확인하시고 가입해주세요.");
			return false;
		}
//      //지점 선택 유무
		if (branchCombo.getValue() == null) {
			CommonService.msg("지점선택은 필수 선택입니다. 확인하시고 가입해주세요.");
			return false;
		}
		regDao.insert(reg);
		regDao.disconnection();
		CommonService.windowsClose(Register);
		opener.Login();
		CommonService.msg("취뽀회원이 되신걸 진심으로 환영합니다.");
		/////////////////////////////////////////////////////////////////// (로그인페이지
		/////////////////////////////////////////////////////////////////// 화면전환)
		return true;
	}

}
