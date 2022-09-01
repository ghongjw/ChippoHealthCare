package _9_UserPTUpdate;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.Opener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class UPController implements Initializable{
	
	private UPService upservice;

	@FXML private Button start;
	@FXML private Button end;
	
	@FXML private Label pttime;
	@FXML private Label workoutstart;
	@FXML private Label workoutend;
	
	private Opener opener;
	
	public void setOpener(Opener opener) {
		this.opener = opener;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		
	}
	
	public void cancle() { 
		
		
	}
	
	public void  back() {
		
		opener.umOpen();
	}
	
	public void startButton () {}
	
	public void endButton () {}
	
	
	
}


