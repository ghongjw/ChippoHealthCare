package _22_findId;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import _0_main.CommonService;
import _0_main.Opener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class FindIdController implements Initializable{
	@FXML private TextField name;   
	@FXML private TextField id;  
	@FXML private TextField moble;
	@FXML private TextField confirmNum;
	
	private FindIDService findIdService;
	private Opener opener;

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
			findIdService = new FindIDService();
		}
	
		public void confirmNumCheck() {
			System.out.println("test");
			opener.FindId1Open();
		}
		public void confirmNum() {
			
			CommonService.msg("737373");
		}

		public void setOpener(Opener opener) {
			this.opener = opener;
		}
		
		
}
