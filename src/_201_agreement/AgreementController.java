package _201_agreement;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.CommonService;
import _0_main.Opener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;

public class AgreementController implements Initializable{
	private AgreementService agreementService;
	private Parent agreement;
	private Opener opener;
	@FXML private CheckBox check1;
	@FXML private CheckBox check2;
	@FXML private CheckBox check3;
	public void setAgreement(Parent agreement) {
		this.agreement = agreement;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		agreementService = new AgreementService();
	}
	public void agreProc() {
		agreementService.agreProc(agreement);
		if(!(check1.isSelected())) {
			CommonService.msg("필수 개인약관 동의 후 가입해주세요. ");
			return;
		}
		if(!(check2.isSelected())) {
			CommonService.msg("필수 개인약관 동의 후 가입해주세요. ");
			return;
		}
		if(!(check3.isSelected())) {
			CommonService.msg("필수 개인약관 동의 후 가입해주세요. ");
			return;
		}
		opener.registerOpen();
	
	}
		public void agreCancelProc() {
			opener.Login();
		}
		public void setOpener(Opener opener) {
			this.opener = opener;
		}
		public void setRegister(Parent register) {
		}

	} 


	