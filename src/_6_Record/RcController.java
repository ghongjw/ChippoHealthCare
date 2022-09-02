package _6_Record;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import _0_main.CommonService;
import _0_main.Opener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.util.Callback;

public class RcController implements Initializable{
	static String stryear;
	static String strmonth;
	static String strday;
	private Opener opener;
	private String name;
	private String id;
	private String date;
	private String StartT;
	private String EndTime;
	private RcService rcService;
	private String sHour,sMin,eHour,eMin;
	private String clikedDate;

	@FXML private Button backButton;
	@FXML private Button RcSaveButton;
	@FXML private DatePicker rcDatePicker;
	@FXML private ComboBox<String> Shour;
	@FXML private ComboBox<String> Smin;
	@FXML private ComboBox<String> Ehour;
	@FXML private ComboBox<String> Emin;
	@FXML private Label StartTimeLabel;
	@FXML private Label EndTimeLabel;
	@FXML private TextArea recordArea;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rcService = new RcService();
		Shour.getItems().addAll("01","02","03","04","05","06","07","08","09","10","11","12",
				"13","14","15","16","17","18","19","20","21","22","23","24");
		Ehour.getItems().addAll("01","02","03","04","05","06","07","08","09","10","11","12",
				"13","14","15","16","17","18","19","20","21","22","23","24");
		Smin.getItems().addAll("0","01","02","03","04","05","06","07","08","09",
				"10","11","12","13","14","15","16","17","18","19",
				"20","21","22","23","24","25","26","27","28","29",
				"30","31","32","33","34","35","36","37","38","39",
				"40","41","42","43","44","45","46","47","48","49",
				"50","51","52","53","54","55","56","57","58","59");
		Emin.getItems().addAll("0","01","02","03","04","05","06","07","08","09",
				"10","11","12","13","14","15","16","17","18","19",
				"20","21","22","23","24","25","26","27","28","29",
				"30","31","32","33","34","35","36","37","38","39",
				"40","41","42","43","44","45","46","47","48","49",
				"50","51","52","53","54","55","56","57","58","59");


		//과거만 선택가능
		Callback<DatePicker, DateCell> callB = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker param) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty); 
						//To change body of generated methods, choose Tools | Templates.
						LocalDate today = LocalDate.now();
						setDisable(empty || item.compareTo(today) > 0);
						LocalDate localDate = rcDatePicker.getValue();
						if(localDate != null) {
							date = localDate.toString();
						}

					}
				};
			}

		};
		rcDatePicker.setDayCellFactory(callB);
	}

	//유저메인으로 돌아가기
	public void backButtonProc() {
		opener.umOpen();
		rcService.discon();
	}
	
	public void RcSaveButtonProc() {
		int sh=0;
		int eh=0;
		int sm=0; 
		int em=0; 
		try {
		sHour = Shour.getValue();
		sMin = Smin.getValue();
		eHour =Ehour.getValue();
		eMin = Emin.getValue();
		sh = Integer.parseInt(sHour);
		eh = Integer.parseInt(eHour);
		sm = Integer.parseInt(sMin);
		em = Integer.parseInt(eMin);
		
		StartT=sHour+":"+sMin;
		EndTime=eHour+":"+eMin;}
		catch(Exception e){
			CommonService.msg("시간을 입력 해 주세요");
			
		}
		if(rcDatePicker.getValue()==null||Shour==null||Smin==null||Ehour==null||Emin==null) {
			CommonService.msg("시간을 입력 해 주세요");
		}else {
			if(em<sm) {
				if(eh<=sh) {
					CommonService.msg("시간을 역행하고 있어요!");
				}else {
					System.out.println("a");
					rcService.setRsetRecordInsertecord(id,date,StartT,EndTime,recordArea.getText());
					CommonService.msg("저장되었습니다");
					}
			}else {
				System.out.println("b");
				rcService.setRsetRecordInsertecord(id,date,StartT,EndTime,recordArea.getText());
				CommonService.msg("저장되었습니다");
			}
		}

	}
	public void setOpener(Opener opener) {
		this.opener=opener;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setClickedDate(String clikedDate) {
		this.clikedDate=clikedDate;
		String[] tmp = clikedDate.split("-");
		System.out.println(clikedDate);
		int cYear= Integer.parseInt(tmp[0]);
		int cMon= Integer.parseInt(tmp[1]);
		int cDay= Integer.parseInt(tmp[2]);
		
		rcDatePicker.setValue(LocalDate.of(cYear,cMon,cDay));
	}



}
