package _4_perchase;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.CommonService;
import _0_main.Opener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PcConfirmController implements Initializable{
	private PcConfirmController pcconfirmCon;
	private PcService pcService;
	private PcController pcController;
	private Opener opener;
	private Parent pcConfirmForm;
	@FXML private Button psmademindButton;
	@FXML private Button pscancelButton;
	@FXML private Label pchowmuch;
	private int monthFare=0;
	
	private int ptFare=0;
	private int totalFarecal=0;
	private int MonthTotalFare=0;
	String id;

	public void initialize(URL location, ResourceBundle resources) {
		
	}
	public void setOpener(Opener opener) {
		this.opener=opener;
		id = opener.getId();
	}
	public void setpcConfirmForm(Parent pcConfirmForm) {
		this.pcConfirmForm=pcConfirmForm;
	}

	public void setPcController(PcController pcController) {
		this.pcController=pcController;
		monthFare=pcController.getMonthFare();
		ptFare=pcController.getPtFare();
		totalFarecal=pcController.getTotalFarecal();
		pcService=pcController.getPcService();
		System.out.println(pcService);
		pcService.setPcController(pcController);
		pchowmuch.setText(Integer.toString(totalFarecal)+"원을 결제하시겠습니까?");
		
	}

	public void setpcController(PcController pcCon) {
		this.pcController=pcCon;
	}

	public void setpcConfirmController(PcConfirmController pcconfirmCon) {

		this.pcconfirmCon=pcconfirmCon;
	}

	public void psmademindButtonProc() {
		//System.out.println("a id :"+id);
		pcService.perchaced(id,monthFare,ptFare);
		CommonService.msg("결제되었습니다.");
		CommonService.windowsClose(pcConfirmForm);
		opener.umOpen();
	}
	public void pscancelButtonProc() {
		CommonService.windowsClose(pcConfirmForm);
	}
	public int getMonthFare() {
		return monthFare;
	}
	public int getPtFare() {
		return ptFare;
	}
	

}
