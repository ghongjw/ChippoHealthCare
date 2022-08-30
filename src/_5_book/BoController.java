package _5_book;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import _0_main.CommonService;
import _0_main.Opener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.util.Callback;

public class BoController implements Initializable {
	@FXML private ComboBox<String> boSetBranch;
	@FXML private ComboBox<String>  boSetTrainer;
	@FXML private DatePicker boDatePicker;
	@FXML private RadioButton boT1,boT2,boT3,boT4,boT5,boT6,boT7,boT8,boT9;
	@FXML private Label selCheck;
	@FXML private Button bookbutton;
	@FXML private Button backButton;
	

	private Parent parent;
	private Opener opener;
	private String branch;
	private String id;//유저아이디
	private String name;//유저이름
	private String trainername;
	private BoDTO boDto=new BoDTO();
	LocalDate pikedDate;
	private int year,month,day,todayYear,todayMonth,todayDay;
	private String date;
	private BoService boService;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		boService=new BoService();

		boT1.setVisible(false);
		boT2.setVisible(false);
		boT3.setVisible(false);
		boT4.setVisible(false);
		boT5.setVisible(false);
		boT6.setVisible(false);
		boT7.setVisible(false);
		boSetBranch.getItems().addAll("영등포점","창동점","홍제점",
				"의정부점","강남점","송파점","분당점","성수점","노량진","부산점");
		// Create action event

		boSetBranch.valueProperty().addListener(new ChangeListener<String>() {
			@Override 
			public void changed(ObservableValue ov, String t, String t1) {

				boSetTrainer.getItems().clear();
				branch=t1;
				ArrayList<String> trainers = boService.getTrainerInfo(branch);
				for(int i=0;i<trainers.size();i++) {
					boSetTrainer.getItems().add(trainers.get(i));
				}
			}    
		});
		boSetTrainer.valueProperty().addListener(new ChangeListener<String>() {
			@Override 
			public void changed(ObservableValue ov, String t, String t1) {
				trainername=t1;
				System.out.println(trainername);


			}

		});
		//데이트픽커 과거선택불가
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
						setDisable(empty || item.compareTo(today) < 0 || item.compareTo(endDay) > 0);
						LocalDate localDate = boDatePicker.getValue();
						if(localDate != null) {
							date = localDate.toString();
						}

					}
				};
			}

		};
		boDatePicker.setDayCellFactory(callB);
	}
	public void setboconForm(Parent boForm) {
		this.parent=boForm;
	}
	public void setOpener(Opener opener) {
		this.opener=opener;

	}
	public void branchselectProc(){
	}

	public void findbuttonproc() {
		radioButtonSet();
		bookbutton.setVisible(true);
		
	}
	public void bookButtonProc() {
		if(boT1.isSelected()==false
				&& boT2.isSelected()==false
				&&boT3.isSelected()==false
				&&boT4.isSelected()==false
				&&boT5.isSelected()==false
				&&boT6.isSelected()==false
				&&boT7.isSelected()==false
				&&boT8.isSelected()==false				
				&&boT9.isSelected()==false) {
			CommonService.msg("선택해주세요");
		}else {
			workoutdayinsertservice(date,id);
			String time = "";
			if(boT1.isSelected()) {
				time = "T1";
				boService.bookPtTime(trainername,name, time, date,id);
			}else if(boT2.isSelected()) {
				time = "T2";
				boService.bookPtTime(trainername,name, time, date,id);
			}
			else if(boT3.isSelected()) {
				time = "T3";
				boService.bookPtTime(trainername,name, time, date,id);
			}
			else if(boT4.isSelected()) {
				time = "T4";
				boService.bookPtTime(trainername,name, time, date,id);
			}
			else if(boT5.isSelected()) {
				time = "T5";
				boService.bookPtTime(trainername,name, time, date,id);
			}
			else if(boT6.isSelected()) {
				time = "T6";
				boService.bookPtTime(trainername,name, time, date,id);
			}else if(boT7.isSelected()) {
				time = "T7";
				boService.bookPtTime(trainername,name, time, date,id);
			}else if(boT8.isSelected()) {
				time = "T8";
				boService.bookPtTime(trainername,name, time, date,id);
			}else if(boT9.isSelected()) {
				time = "T9";
				boService.bookPtTime(trainername,name, time, date,id);
			}
			CommonService.msg("등록되었습니다.");
			opener.umOpen();
		}
		
	}
	public void backButtonProc() {
		System.out.println("select");
		opener.umOpen();
	}
	public void radioButtonSet(){
		if(branch==null||trainername==null||date==null) {
			CommonService.msg("입력정보를 확인 해 주세요");
		}else {
			String[] times = boService.getTrainerTime(trainername,date,boDto);
			RadioButton[] radioButtons = {boT1,boT2,boT3,boT4,boT5,boT6,boT7,boT8,boT9};
			String[] setTimes= {"7시","9시","11시","13시","15시","17시","19시","21시","23시"};


			for(int i=0; i<times.length ; i++) {
				radioButtons[i].setSelected(false);
				radioButtons[i].setVisible(true);
				if(times[i].equals("n")||times[i]==null) {
					radioButtons[i].setDisable(true);
					radioButtons[i].setText("선택할 수 없습니다");
				}else if(times[i].equals("y")) {
					radioButtons[i].setDisable(false);
					radioButtons[i].setText(setTimes[i]);
				}
			}
		}
	}
	public void workoutdayinsertservice(String date,String id ) {
		boService.workoutdayinsert(date, id);
	}
	public void getUserId(String id) {
		this.id=id;
	}
	public void getUserName(String name) {
		this.name=name;

	}


}

