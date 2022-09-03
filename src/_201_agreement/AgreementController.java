package _201_agreement;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.CommonService;
import _0_main.Opener;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class AgreementController implements Initializable{
	private AgreementService agreementService;
	private Parent agreement;
	private Opener opener;
	
	public void setAgreement(Parent agreement) {
		this.agreement = agreement;
	}
//	private Opener opener;
	
//	public void setOpener(Opener opener) {
//			this.opener = opener;
//	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		agreementService = new AgreementService();
		
	}
	

	
	public void agreProc() {
			agreementService.agreProc(agreement);
		
			opener.registerOpen();
		}
	
		public void agreCancelProc() {
//			System.out.println("test");
//			agreementService.agreCancelProc(agreement);
			CommonService.windowsClose(agreement);

		
		}
	
		public void setOpener(Opener opener) {
			this.opener = opener;
			
		}
	
	
	public void setRegister(Parent register) {
	
		
	}


	
}
