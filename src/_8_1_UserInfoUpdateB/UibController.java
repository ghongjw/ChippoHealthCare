package _8_1_UserInfoUpdateB;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.CommonService;
import _0_main.Opener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class UibController implements Initializable {

	@FXML
	private TextField pw;
	@FXML
	private TextField pwcon;
	@FXML
	private TextField email;
	@FXML
	private TextField address;
	@FXML
	private TextField phone;
	@FXML
	private RadioButton men;
	@FXML
	private RadioButton women;
	@FXML
	private ComboBox point;
	@FXML
	private ComboBox emailbox;

	private UibDAO uibdao;
	private UibService uibservice;
	private Opener opener;

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		uibservice = new UibService();

		point.getItems().addAll("1. 영등포점", "2. 창동점", "3. 홍제점", "4. 의정부점", "5. 강남점", "6. 송파점", "7. 분당점", "8. 성수점",
				"9. 노량진점", "10. 부산점");

		emailbox.getItems().addAll("naver.com", "gmail.com", "hanmail.net", "daum.net");
	}

	public void confirm() {

		uibservice.userinfoupdateProc(pw, pwcon, email, emailbox, phone, address, men, women, point);

		CommonService.msg("등록되었습니다.");
		opener.umOpen();
	}

	public void back() {

		opener.userInfoUpdateConfirmPwOpen();

	}

}