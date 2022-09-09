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
	private RcDTO rcDto;
	
	private String sHour,sMin,eHour,eMin;
	private String clikedDate;
	private String pickedDate;
	private String textAreaMemo;

	@FXML private Button backButton;
	@FXML private Label ptReserviedLabel;
	@FXML private Label workoutTimeLabel;
	@FXML private Label savedTimeLabel;
	@FXML private Label labelFirst;
	//@FXML private Label labelSecond;
	//@FXML private Label LabelThird;
	//@FXML private Label labelForth;
	
	
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
		rcDto = rcService.getRcDto();
		Shour.getItems().addAll("","01","02","03","04","05","06","07","08","09","10","11","12",
				"13","14","15","16","17","18","19","20","21","22","23","24");
		Ehour.getItems().addAll("","01","02","03","04","05","06","07","08","09","10","11","12",
				"13","14","15","16","17","18","19","20","21","22","23","24");
		Smin.getItems().addAll("","00","01","02","03","04","05","06","07","08","09",
				"10","11","12","13","14","15","16","17","18","19",
				"20","21","22","23","24","25","26","27","28","29",
				"30","31","32","33","34","35","36","37","38","39",
				"40","41","42","43","44","45","46","47","48","49",
				"50","51","52","53","54","55","56","57","58","59");
		Emin.getItems().addAll("","00","01","02","03","04","05","06","07","08","09",
				"10","11","12","13","14","15","16","17","18","19",
				"20","21","22","23","24","25","26","27","28","29",
				"30","31","32","33","34","35","36","37","38","39",
				"40","41","42","43","44","45","46","47","48","49",
				"50","51","52","53","54","55","56","57","58","59");

		rcDatePicker.valueProperty().addListener((ov, oldValue, newValue) -> {
			date = newValue.toString();
			rcService.setRsetRecord(id,date);
			setlabelsandtexts();
        });
	}
	
	//유저메인으로 돌아가기
	public void backButtonProc() {
		opener.umOpen();
		rcService.discon();
	}
	//저장버튼
	public void RcSaveButtonProc() {
		sHour = Shour.getValue();
		sMin = Smin.getValue();
		eHour =Ehour.getValue();
		eMin = Emin.getValue();
		
		textAreaMemo=recordArea.getText();
		
		rcService.saveButtonclick(sHour,sMin,eHour,eMin,date,textAreaMemo,id);
		setlabelsandtexts();
		RcCancleButtonProc();
	}
	public void RcCancleButtonProc(){
		Shour.setPromptText("");
		Smin.setPromptText("");
		Ehour.setPromptText("");
		Emin.setPromptText("");
		recordArea.clear();
		
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
		System.out.println("clicked"+clikedDate);
		int cYear= Integer.parseInt(tmp[0]);
		int cMon= Integer.parseInt(tmp[1]);
		int cDay= Integer.parseInt(tmp[2]);
		rcDatePicker.setValue(LocalDate.of(cYear,cMon,cDay));
		setlabelsandtexts();
	}
	public void setlabelsandtexts() {
		rcService.setRsetRecord(id,date);
		ptReserviedLabel.setText(rcDto.getPtReserviedLabelT());
		workoutTimeLabel.setText(rcDto.getWorkoutTimeLabelT());
		savedTimeLabel.setText(rcDto.getSavedTimeLabelT());
		labelFirst.setText(rcDto.getFirstT());
	}
}
