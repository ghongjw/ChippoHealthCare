package _4_perchase;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.Opener;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class PcConfirmController implements Initializable{
	PcService pcService;
	private Opener opener;
	private Parent pcConfirmForm;
	public void initialize(URL location, ResourceBundle resources) {
	
	}

	public void setOpener(Opener opener) {
		this.opener=opener;
	}
	public void setpcConfirmForm(Parent pcConfirmForm) {
		this.pcConfirmForm=pcConfirmForm;
	}

}
