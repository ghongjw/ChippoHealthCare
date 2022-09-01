package _23_findpw;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.CommonService;
import _0_main.Opener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class FindPwController implements Initializable{
	@FXML private TextField name;   
	@FXML private TextField id;  
	@FXML private TextField moble;;     
	@FXML private TextField confirmNum;
	
	private FindPWService findPwService;
	private Opener opener;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		findPwService = new FindPWService();
	}
	public void confirmNumCheck() {
		System.out.println("test");
		opener.Findpw1Open();
	}
	public void confirmNum() {
		
		CommonService.msg("737373");
	}
	public void setOpener(Opener opener) {
		this.opener = opener;
	}
	 
	
}
