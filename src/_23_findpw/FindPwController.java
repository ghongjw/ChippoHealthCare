package _23_findpw;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import _0_main.CommonService;
import _0_main.Opener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class FindPwController implements Initializable {
	@FXML
	private TextField nameField;
	@FXML
	private TextField idField;
	@FXML
	private TextField mobileField;;
	@FXML
	private TextField confirmNumField;

	private FindPWService findPwService;
	private Opener opener;
	private String conName;
	private String conMobile;
	private String conId;
	private String confirmtest = "";
	private FindPwDTO findPwDTO;
//	public String resultNum = "";
//	private Parent FindPw0;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		findPwService = new FindPWService();
		findPwDTO = new FindPwDTO();
	}

	public void confirmNumCheck() {
		System.out.println(findPwDTO.getconfirmNum() + "\t" + confirmNumField.getText());
		if (nameField.getText().equals(findPwDTO.getName()) && mobileField.getText().equals(findPwDTO.getMobile())
				&& confirmNumField.getText().equals(findPwDTO.getconfirmNum())) {
			CommonService.msg("인증되었습니다.");
		} else
			CommonService.msg("인증번호를 다시 확인해주세요");
	}

	public void next() {
		if (nameField.getText().equals(findPwDTO.getName()) && mobileField.getText().equals(findPwDTO.getMobile())
				&& confirmNumField.getText().equals(findPwDTO.getconfirmNum())) {
			opener.Findpw1Open();
		} else {
			CommonService.msg("인증번호을 다시 확인해주세요");
		}
	}

	public void confirmNum() {
		conId = idField.getText();
		conName = nameField.getText();
		conMobile = mobileField.getText();

		if (idField.getText().equals("") || nameField.getText().equals("") || conMobile.equals("")) {
			CommonService.msg("빈칸을 확인 하시고 다시 입력해주세요");
		} else {
			conMobile = conMobile.replaceAll(Pattern.quote("-"), "");
			if (conMobile.length() == 11) {
				conMobile = conMobile.substring(0, 3) + "-" + conMobile.substring(3, 7) + "-" + conMobile.substring(7);
				if (findPwService.getPw(nameField.getText(), conMobile, opener, conId)) {
					confirmtest = findPwService.getConfirmtest();
					findPwDTO.setconfirmNum(confirmtest);
					findPwDTO.setMobile(conId);
					findPwDTO.setName(conName);
					findPwDTO.setMobile(conMobile);
				}
			} else if (conMobile.length() != 11) {
				CommonService.msg("전화번호를 확인해 주세요\n '-'를 포함한 14자리 숫자를 입력해 주세요.");
			}
		}
	}

	public void backButtonProc() {
		opener.idpwOpen();
	}

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	public FindPWService getFindPwService() {
		return findPwService;
	}

}
