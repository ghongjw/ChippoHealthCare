package _4_perchase;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.Opener;
import javafx.fxml.Initializable;

public class PcController implements Initializable{
	
	Opener opener;
	
	//@FXML
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		
	}

	public void setOpener(Opener opener) {
		this.opener = opener;
		
	}
	
	
}
