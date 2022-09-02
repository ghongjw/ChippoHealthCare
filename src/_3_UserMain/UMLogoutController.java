package _3_UserMain;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;

import _0_main.CommonService;
import _0_main.Opener;
import _4_perchase.PcConfirmController;
import _4_perchase.PcController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.WindowEvent;

public class UMLogoutController implements Initializable {
	@FXML
	Button logoutbutton;
	@FXML
	Button logoutcanclecancelButton;
	// 서비스불러오기
	private UMService umService;
	private Opener opener;
	private Parent logoutForm;
	private UMController umCon;
	private UMLogoutController UmLougoutCon;
	private String id;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	// opener 참조값 불러오기
	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	public void gotoWelcompageButtonProc() {
		if (umService.setlogout(id)) {
			umService.disconnection();
			opener.welcomeOpen();
			CommonService.windowsClose(logoutForm);
		} else
			CommonService.windowsClose(logoutForm);
	}
	public void ex() {
		if (umService.setlogout(id)) {
			umService.disconnection();
			opener.welcomeOpen();
			CommonService.windowsClose(logoutForm);
		} else
			CommonService.windowsClose(logoutForm);
	}

	public void pscancelButtonProc() {
		CommonService.windowsClose(logoutForm);
	}

	public void setumConfirmForm(Parent logoutForm) {
		this.logoutForm = logoutForm;
	}

	public void setUmController(UMController umCon) {
		this.umCon = umCon;
		umService = umCon.getUmService();

	}

	public void setUmService(UMService umService) {
		this.umService = umService;
	}


	public void setid(String id) {
		this.id = id;
	}
	public void setUmcon(UMLogoutController UmLougoutCon){
		this.UmLougoutCon=UmLougoutCon;
	}

	


}
