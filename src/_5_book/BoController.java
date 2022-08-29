package _5_book;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import _0_main.Opener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;

public class BoController implements Initializable {
	@FXML private ComboBox<String> boSetBranch;
	@FXML private ComboBox<String>  boSetTrainer;
	@FXML private DatePicker boDatePicker;
	@FXML private RadioButton boT1,boT2,boT3,boT4,boT5,boT6,boT7;
	private Parent parent;
	private Opener opener;
	private String branch;
	
	private BoService boService;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		boService=new BoService();
		
		boSetBranch.getItems().addAll("영등포점","창동점","홍제점",
				"의정부점","강남점","송파점","분당점","성수점","노량진","부산점");
        // Create action event
		
		boSetBranch.valueProperty().addListener(new ChangeListener<String>() {
	        @Override 
	        public void changed(ObservableValue ov, String t, String t1) {
	        	System.out.println("t : "+t);
	        	System.out.println("t1 : "+t1);
	        boSetTrainer.getItems().clear();
	         branch=t1;
	         ArrayList<String> trainers = boService.getTrainerInfo(branch);
         	for(int i=0;i<trainers.size();i++) {
         		boSetTrainer.getItems().add(trainers.get(i));
         	}
	        }    
	    });
	}
	public void setboconForm(Parent boForm) {
		this.parent=boForm;
	}
	public void setOpener(Opener opener) {
		this.opener=opener;
		
	}
	public void branchselectProc(){
		System.out.println("select");
	}
	
	
}
