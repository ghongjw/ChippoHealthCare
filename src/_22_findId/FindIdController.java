package _22_findId;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import _0_main.CommonService;
import _0_main.Opener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class FindIdController implements Initializable {
	@FXML private TextField name;
	@FXML private TextField id;
	@FXML private TextField mobile;
	@FXML private TextField confirmNum;

	private FindIDService findIdService;
	private Opener opener;
	private String conName;
	private String conMobile;
	private String confirmtest = "";
	private FindIdDTO findIdDTO;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		findIdService = new FindIDService();
		findIdDTO = new FindIdDTO();
	}

	public void confirmNumCheck() {
		System.out.println(findIdDTO.getconfirmNum() + "\t" + confirmNum.getText());
		if (name.getText().equals(findIdDTO.getName()) && mobile.getText().equals(findIdDTO.getMobile())
				&& confirmNum.getText().equals(findIdDTO.getconfirmNum())) {
			opener.FindId1Open();
		} else
			CommonService.msg("다시 확인 해 주세요");
	}

	public void confirmNum() {
		conName = name.getText();
		conMobile = mobile.getText();
		if (name.getText().equals("") || conMobile.equals("")) {
			CommonService.msg("이름과 번호를 입력해주세요");
		} else {
			conMobile = conMobile.replaceAll(Pattern.quote("-"), "");
			if (conMobile.length() == 11) {
				conMobile = conMobile.substring(0, 3) + "-" + conMobile.substring(3, 7) + "-" + conMobile.substring(7);
				if (findIdService.getid(name.getText(), conMobile, opener)) {
					confirmtest = findIdService.getConfirmtest();
					findIdDTO.setconfirmNum(confirmtest);
					findIdDTO.setName(conName);
					findIdDTO.setMobile(conMobile);
				}
			} else if (conMobile.length() != 11) {
				CommonService.msg("전화번호를 확인해 주세요\n '-'를 포함한 14자리 숫자를 입력해 주세요.");
			}
		}
	}

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	public void backbuttonproc() {
		opener.Login();
	}

	public FindIDService getFindIdService() {
		return findIdService;
	}
}