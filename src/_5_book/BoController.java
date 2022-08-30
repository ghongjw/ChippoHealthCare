package _5_book;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import _0_main.Opener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
	@FXML private RadioButton boT1,boT2,boT3,boT4,boT5,boT6,boT7;
	@FXML private Label selCheck;
	private Parent parent;
	private Opener opener;
	private String branch;
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
						setDisable(empty || item.compareTo(today) < 0);
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
		System.out.println("select");
	}
	public void radiobuttonisable() {
		if(boDto.getT1()==null||boDto.getT1().equals("N")) {
			boT1.setDisable(true);
		}
	}
	public void findbuttonproc() {
		radioButtonSet(boT1);
		radioButtonSet(boT2);
		radioButtonSet(boT3);
		radioButtonSet(boT4);
		radioButtonSet(boT5);
		radioButtonSet(boT6);
		radioButtonSet(boT7);
			

		}

		public void radioButtonSet(RadioButton radio){
			System.out.println(branch+trainername+date);

			if(branch==null||trainername==null||date==null) {
				selCheck.setText("입력정보를 확인 해 주세요");
			}else {
				boService.getTrainerTime(trainername,date,boDto);
				//System.out.println(boDto.getT1());
				if(boDto.getT1().equals("n")||boDto.getT1()==null) {
					radio.setVisible(true);
					radio.setDisable(true);
					radio.setText("선택할 수 없습니다");
				}else if(boDto.getT1().equals("Y")) {
					radio.setVisible(true);
					radio.setDisable(false);
				}

			}
		}


	}

