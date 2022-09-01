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
	@FXML
	private TextField name;
	@FXML
	private TextField id;
	@FXML
	private TextField moble;
	@FXML
	private TextField confirmNum;

	private FindIDService findIdService;
	private Opener opener;
	private String conName;
	private String conMoblie;
	private String confirmtest="";
	private FindIdDTO findIdDTO;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		findIdService = new FindIDService();
		findIdDTO = new FindIdDTO();

	}

	public void confirmNumCheck() {
		System.out.println(findIdDTO.getconfirmNum()+confirmNum.getText());
		if(name.getText().equals(findIdDTO.getName())
				&&moble.getText().equals(findIdDTO.getMoblie())&&
				confirmNum.getText().equals(findIdDTO.getconfirmNum())){
			opener.FindId1Open();
		}else CommonService.msg("다시 확인 해 주세요");
	}

	public void confirmNum() {
		conName=name.getText();
		conMoblie=moble.getText();
		if(name.getText().equals("")||conMoblie.equals("")) {
			CommonService.msg("이름과 번호를 입력해주세요");
		}
		else{
			conMoblie = conMoblie.replaceAll(Pattern.quote("-"), "");
			if (conMoblie.length() == 11) {
				// 010-1234-1234
				conMoblie = conMoblie.substring(0, 3) + "-" + conMoblie.substring(3, 7) + "-" + conMoblie.substring(7);
				if(findIdService.getid(name.getText(),conMoblie,opener)) {
					confirmtest = findIdService.getConfirmtest();
					findIdDTO.setconfirmNum(confirmtest);
					findIdDTO.setName(conName);
					findIdDTO.setMoblie(conMoblie);
				}
			}
			else if(conMoblie.length() != 11){
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
