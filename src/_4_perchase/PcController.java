package _4_perchase;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.Opener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class PcController implements Initializable{
	private Opener opener;
	
	@FXML private ComboBox<Integer> pcPerUse;
	@FXML private ComboBox<Integer> pcPTPer;
	@FXML Label pcUseMonth;
	@FXML Label pcUseFare,pcUseFare2;
	@FXML Label pcPtcount;
	@FXML Label pcPtFare,pcPtFare2;
	@FXML Label totalFare;
	@FXML Button pcBackbutton;
	@FXML Button pcSubmitButton;
	@FXML Button pcCancleButton;
	PcService pcService;
	private int monthFare=0;
	private int ptFare=0;
	private int totalFarecal=0;
	private int MonthTotalFare=0;
	private int PTTotalFare=0;
	//private Parent pcconForm;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pcService=new PcService();
		
		pcPerUse.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12);
        // Create action event
        EventHandler<ActionEvent> event =
                  new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                pcUseMonth.setText(Integer.toString(pcPerUse.getValue()));
                monthFare = pcPerUse.getValue();
                pcUseFare.setText(Integer.toString(monthFareCal()));
                pcUseFare2.setText(Integer.toString(monthFareCal()));
               totalFareCal();
               totalFare.setText(Integer.toString(totalFarecal));
            }
        };
        
        // Set on action
        pcPerUse.setOnAction(event);
        
        pcPTPer.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        // Create action event
        EventHandler<ActionEvent> PTevent =
                  new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
            	pcPtcount.setText(Integer.toString(pcPTPer.getValue()));
            	ptFare = pcPTPer.getValue();
            	pcPtFare.setText(Integer.toString(ptFare*65000));
            	pcPtFare2.setText(Integer.toString(ptFare*65000));
            	PTTotalFare=ptFare*65000;
            	totalFareCal();
            	totalFare.setText(Integer.toString(totalFarecal));
            }
        };
        // Set on action
        pcPTPer.setOnAction(PTevent);
       
	}
	public void setOpener(Opener opener) {
		this.opener = opener;
	}
	public int monthFareCal() {
		if(monthFare<3) {
			MonthTotalFare=monthFare*100000;
			//pcUseFare2.setText(Integer.toString(monthFare*100000));
		}if(monthFare<6&&monthFare>=3) {
			MonthTotalFare=monthFare*95000;
			//pcUseFare2.setText(Integer.toString(monthFare*95000));
		}if(monthFare>=6) {
			MonthTotalFare=monthFare*90000;
			//pcUseFare2.setText(Integer.toString(monthFare*90000));
		}
		return MonthTotalFare;
	}
	public void totalFareCal() {
		totalFarecal = MonthTotalFare+PTTotalFare;
	}
	public void pcBackbuttonProc() {
		System.out.println("why");
		opener.umOpen();
	}
	public void pcSubmitButtonProc() {
		System.out.println("why");
		opener.comfirmPc();
	}
	public void pcCancleButtonProc() {
		System.out.println("why");
		opener.umOpen();
	}
//	public void setpconForm(Parent pcconForm) {
//		this.pcconForm = pcconForm;
//	}



}
