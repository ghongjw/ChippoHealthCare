package _4_perchase;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.CommonService;
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
	private PcDTO pcDto;
	@FXML private ComboBox<Integer> pcPerUse;
	@FXML private ComboBox<Integer> pcPTPer;
	@FXML private Label pcUseMonth;
	@FXML private Label pcUseFare,pcUseFare2;
	@FXML private Label pcPtcount;
	@FXML private Label pcPtFare,pcPtFare2;
	@FXML private Label totalFare;
	@FXML private Button pcBackbutton;
	@FXML private Button pcSubmitButton;
	@FXML private Button pcCancleButton;
	private PcService pcService;
	private PcController pcController;
	private PcConfirmController pcConfirmController;
	private int monthFare=0;
	private int ptFare=0;
	private int totalFarecal=0;
	private int MonthTotalFare=0;
	
	private int PTTotalFare=0;
	//private Parent pcconForm;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		pcService=new PcService();
		pcPerUse.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10,11,12);
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
        
        pcPTPer.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10);
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
		if (totalFarecal==0) {
			CommonService.msg("이용권을 선택해 주세요");
		}else {
			opener.comfirmPc();
		}
	}
	public void pcCancleButtonProc() {
		opener.umOpen();
	}
	public void setPcDto(PcDTO pcDto) {
		this.pcDto=pcDto;
		
	}
	public void setPcConfirmController(PcConfirmController pcConfirmController) {
		this.pcConfirmController=pcConfirmController;
	}
	
	public void setpcController(PcController pcCon) {
		this.pcController=pcCon;
	}
	public PcService getPcService(){
		return pcService;
	}
	public int getMonthFare() {
		return monthFare;
	}
	public int getPtFare() {
		return ptFare;
	}
	public int getTotalFarecal() {
		return totalFarecal;
	}
	public int getMonthTotalFare() {
		return MonthTotalFare;
	}
	public int getPTTotalFare() {
		return PTTotalFare;
	}
	public PcService pcService() {
		return pcService;
	}




}
