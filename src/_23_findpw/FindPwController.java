package _23_findpw;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import _0_main.CommonService;
import _0_main.Opener;
import _22_findId.FindIDService;
import _22_findId.FindIdDTO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class FindPwController implements Initializable {
	@FXML
	private TextField name;
	@FXML
	private TextField id;
	@FXML
	private TextField mobile;;
	@FXML
	private TextField confirmNum;

	private FindPWService findPwService;
	private Opener opener;
	private String conName;
	private String conMobile;
	private String conId;
	private String confirmtest = "";
	private FindPwDTO findPwDTO;
	public String resultNum = "";
	private Parent FindPw0;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		findPwService = new FindPWService();
		findPwDTO = new FindPwDTO();
	}

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	public void setFindPw0(Parent FindPw0) {
		this.FindPw0 = FindPw0;
	}

	public FindPWService getFindPwService() {
		return findPwService;
	}

	public void confirmNumCheck() {
		System.out.println(findPwDTO.getconfirmNum() + confirmNum.getText());
		if (name.getText().equals(findPwDTO.getName()) && mobile.getText().equals(findPwDTO.getMobile())
				&& confirmNum.getText().equals(findPwDTO.getconfirmNum())) {
			opener.Findpw1Open();
		} else
			CommonService.msg("다시 확인해주세요");
	}

	public void confirmNum() {
		System.out.println("id : " + id.getText());
		conId = id.getText();
		System.out.println("이름 : " + name.getText());
		conName = name.getText();
		System.out.println("모바일 번호 가져오는 : " + mobile.getText());
		conMobile = mobile.getText();

		if (id.getText().equals("") || name.getText().equals("") || conMobile.equals("")) {
			CommonService.msg("빈칸을 확인 하시고 다시 입력해주세요");
		} else {
			conMobile = conMobile.replaceAll(Pattern.quote("-"), "");
			if (conMobile.length() == 11) {
				// 010-1234-1234
				conMobile = conMobile.substring(0, 3) + "-" + conMobile.substring(3, 7) + "-" + conMobile.substring(7);
				if (findPwService.getPw(name.getText(), conMobile, opener, conId)) {
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

	public void backProc() {
		opener.idpwOpen();
	}

}
