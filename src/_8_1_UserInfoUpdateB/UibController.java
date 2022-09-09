package _8_1_UserInfoUpdateB;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.CommonService;
import _0_main.Opener;
import _3_UserMain.UMController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UibController implements Initializable {

	@FXML
	private PasswordField pw;
	@FXML
	private PasswordField pwcon;
	@FXML
	private TextField email;
	@FXML
	private TextField address;
	@FXML
	private TextField mobile;
	@FXML
	private TextField age;
	@FXML
	private RadioButton men;
	@FXML
	private RadioButton women;
	@FXML
	private RadioButton diet;
	@FXML
	private RadioButton competition;
	@FXML
	private RadioButton health;
	@FXML
	private ComboBox point;
	@FXML
	private ComboBox emailbox;

	@FXML
	private TextField name;

	private UibDAO uibdao = new UibDAO();

	private UibService uibservice;
	private Opener opener;

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		uibservice = new UibService();

		point.getItems().addAll("영등포점", "창동점", "홍제점", "의정부점", "강남점", "송파점", "분당점", "성수점", "노량진점", "부산점");

		emailbox.getItems().addAll("naver.com", "gmail.com", "hanmail.net", "nate.com");

		UibDTO uibdto = uibdao.information(UMController.staticId);

		address.setText(uibdto.getAddress());
		name.setText(uibdto.getName());
		mobile.setText(uibdto.getMobile());
		point.setValue(uibdto.getPoint());
		age.setText(uibdto.getAge());
		email.setText(uibdto.getEmail());
		emailbox.setValue(uibdto.getEmailbox());

		if (uibdto.getGender().equals("남")) {

			men.setSelected(true);
		}

		else if (uibdto.getGender().equals("여")) {

			women.setSelected(true);
		}

		if (uibdto.getPurpose().equals("diet  ")) {
			diet.setSelected(true);
			System.out.println(uibdto.getPurpose());
		} else if (uibdto.getPurpose().equals("diet  competition  ")) {
			diet.setSelected(true);
			competition.setSelected(true);
			System.out.println(uibdto.getPurpose());
		} else if (uibdto.getPurpose().equals("diet  health")) {
			diet.setSelected(true);
			health.setSelected(true);
			System.out.println(uibdto.getPurpose());
		} else if (uibdto.getPurpose().equals("competition  ")) {
			competition.setSelected(true);
			System.out.println(uibdto.getPurpose());
		} else if (uibdto.getPurpose().equals("competition  health")) {
			competition.setSelected(true);
			health.setSelected(true);
			System.out.println(uibdto.getPurpose());
		} else if (uibdto.getPurpose().equals("health")) {
			health.setSelected(true);
			System.out.println(uibdto.getPurpose());
		} else if (uibdto.getPurpose().equals("diet  competition  health")) {
			diet.setSelected(true);
			competition.setSelected(true);
			health.setSelected(true);
			System.out.println(uibdto.getPurpose());
		}

	}

	public void confirm() {

		UMController umCon = new UMController();

//      //비밀번호 정규식(영문자 숫자 6~15)
		if (!(pw.getText().matches("^[a-z0-9]*$")) || pw.getText().length() > 15 || pw.getText().length() < 3) {
			CommonService.msg("비밀번호 형식이 올바르지 않습니다. 확인하시고 가입해주세요.");
			pw.clear();
			pw.requestFocus();
			return;
		}

//    //이름 공란
		if (name.getText().isEmpty()) {
			CommonService.msg("이름은 필수 입력입니다. 확인하시고 가입해주세요.");
			name.requestFocus();
			return;
		}
//  //영어 한글만 가능
		if (!(name.getText().matches("^[a-zA-Z]*$")) && (!(name.getText().matches("^[가-힣]*$")))) {
			CommonService.msg("이름은 영어 및 한글만 가능합니다. 확인하시고 가입해주세요.");
			name.clear();
			name.requestFocus();
			return;
		}
////전화번호 정규식(010-0000-0000)  
		if (!(mobile.getText().matches("^\\d{3}-\\d{4}-\\d{4}$"))) {
			CommonService.msg("전화번호의 형식이 올바르지 않습니다. 확인하시고 가입해주세요.");
			mobile.clear();
			mobile.requestFocus();
			return;
		}
//   //주소 공란
		if (address.getText().isEmpty()) {
			CommonService.msg("주소는 필수 입력입니다. 확인하시고 가입해주세요.");
			address.requestFocus();
			return;
		}
//   //영어 및 한글과 숫자만 가능
		if (!(address.getText().matches("^[a-zA-Z0-9가-힣]*$"))) {
			CommonService.msg("주소는 영어 및 한글과 숫자만 가능합니다. 확인하시고 가입해주세요.");
			address.clear();
			address.requestFocus();
			return;
		}
//    //성별 체크 유무
		if (!(women.isSelected()) && !(men.isSelected())) {
			CommonService.msg("성별은 필수 선택입니다. 확인하시고 가입해주세요.");
			return;
		}
//  //지점 선택 유무
		if (point.getValue() == null) {
			CommonService.msg("지점선택은 필수 선택입니다. 확인하시고 가입해주세요.");
			return;
		}

		// 패스워드 확인
		if (pw.getText().equals(pwcon.getText()) == true) {

			uibservice.userinfoupdateProc(pw, pwcon, name, age, email, emailbox, mobile, address, men, women, point,
					health, competition, diet, UMController.staticId);

		} else {

			CommonService.msg("비밀번호가 일치하지 않습니다");
			return;

		}

		CommonService.msg("등록되었습니다.");
		opener.umOpen();
	}

	public void back() {

		opener.userInfoUpdateConfirmPwOpen();

	}

}
