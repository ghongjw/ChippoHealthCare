package _6_Record;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

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

	@FXML private Button backButton;
	@FXML private Button Sworkoutbutton;
	@FXML private Button Eworkoutbutton;
	@FXML private Button RcSaveButton;
	@FXML private DatePicker rcDatePicker;
	@FXML private ComboBox<String> SAmPm;
	@FXML private ComboBox<String> Shour;
	@FXML private ComboBox<String> Smin;
	@FXML private ComboBox<String> EAmPm;
	@FXML private ComboBox<String> Ehour;
	@FXML private ComboBox<String> Emin;
	@FXML private Label StartTimeLabel;
	@FXML private Label EndTimeLabel;
	@FXML private TextArea recordArea;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rcService = new RcService();
		SAmPm.getItems().addAll("AM","PM");
		Shour.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12");
		EAmPm.getItems().addAll("AM","PM");
		Ehour.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12");
		for(int i=0;i<59;i++) {
			Smin.getItems().add(Integer.toString(i));
			Smin.getItems().add(Integer.toString(i));
		}
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
						LocalDate endDay = LocalDate.now().plusWeeks(2);
						setDisable(empty || item.compareTo(today) < 0);
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
	}
	public void SworkoutbuttonProc() {
		String sampm = SAmPm.getValue();
		String sHour = Shour.getValue();
		String sMin = Smin.getValue();
		StartT = sampm+" "+sHour+" : "+sMin;
		StartTimeLabel.setText(StartT);
		}
	public void EworkoutbuttonProc() {
		String eampm = EAmPm.getValue();
		String eHour =Ehour.getValue();
		String eMin = Emin.getValue();
		EndTime = eampm+" "+eHour+" : "+eMin;
		StartTimeLabel.setText(EndTime);
	}
	public void RcSaveButtonProc() {
	rcService.setRecord(id,date,StartT,EndTime,recordArea.getText());
		
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

}
