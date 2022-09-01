package _11_0_TrainManagement;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class TMcontroller implements Initializable {
	@FXML
	private VBox schedulebox;
	@FXML
	private ListView<String> pointList;
	@FXML
	private ListView<String> trainerList;
	@FXML
	private DatePicker datepicker;
	@FXML
	private CheckBox time7, time9, time11, time13, time15, time17, time19, time21, time23;
	@FXML
	private Label name7, name9, name11, name13, name15, name17, name19, name21, name23;
	private Opener opener;
	private TMService tmService;
	private TMDTO tmDto = new TMDTO();
	private String point;
	private String trainername;
	private String date;
	private TMDAO tmDao = new TMDAO();

	public void setOpener(Opener opener) {
		this.opener = opener;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		tmService = new TMService();
		tmService.settmDto(tmDto);
		// 지점 추가
		pointList.getItems().addAll("영등포점", "창동점", "홍제점", "의정부점", "강남점", "송파점", "분당점", "성수점", "노량진점", "부산점");

		pointList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				trainerList.getItems().clear();
				point = t1;
				ArrayList<String> trainers = tmService.getTrainerInfo(point);
				for (int i = 0; i < trainers.size(); i++) {
					trainerList.getItems().add(trainers.get(i));
				}
			}
		});
		trainerList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				trainername = t1;
			}
		});

		Callback<DatePicker, DateCell> callB = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker param) {
				return new DateCell() {

					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);
						// To change body of generated methods, choose Tools | Templates.
						LocalDate today = LocalDate.now();
						LocalDate endDay = LocalDate.now().plusWeeks(2);
						setDisable(empty || item.compareTo(today) < 0 || item.compareTo(endDay) > 0);
						LocalDate localDate = datepicker.getValue();
						if (localDate != null) {
							date = localDate.toString();
						}
					}
				};
			}
		};
		datepicker.setDayCellFactory(callB);

	}

	// 트레이너 관리 화면에서 뒤로가기 버튼 누르면 동작하는 메서드
	public void backProc() {
		opener.mmOpen();
	}

	// 트레이너 관리 화면에서 logo 누르면 동작하는 메서드
	public void homeProc() {
		opener.mmOpen();
	}

	// 트레이너 관리 화면에서 등록 버튼 누르면 동작하는 메서드
	public void regProc() {
		//opener.rtOpen();
	}

	// 트레이너 관리 화면에서 삭제 버튼 누르면 동작하는 메서드
	public void delProc() {
		//opener.delOpen();
	}

	// 트레이너 관리 화면에서 검색 버튼 누르면 동작하는 메서드
	public void searchProc() {
		if (point == null || trainername == null || date == null) {
			CommonService.msg("입력정보를 확인 해주세요");
		} else {
			// 검색 눌렀을 때 DB에 스케줄이 있으면 스케줄표를 가져옴
			if (tmService.ScheduleEmpty(point, trainername, date, tmDto) == true) {
				getSchedule();
				schedulebox.setVisible(true);
			}
			// 선택한 날짜에 DB에 스케줄이 없으면 스케줄이 없다는 창 띄우고 생성하겠냐는 버튼(예,아니오)
			else if (tmService.ScheduleEmpty(point, trainername, date, tmDto) == false) {
				schedulebox.setVisible(false);
				//opener.newScheduleOpen();
			}
		}
	}

	// 트레이너 관리 화면에서 저장 버튼 누르면 동작하는 메서드
	public void saveProc() {
		// 저장 눌렀을 때
		// 체크박스 체크유무로 DB에 t1~9를 Y or N 바꿔줌
		CheckBox[] checkBox = { time7, time9, time11, time13, time15, time17, time19, time21, time23 };
		String[] time = { "t1", "t2", "t3", "t4", "t5", "t6", "t7", "t8", "t9" };
		for (int i = 0; i < checkBox.length; i++) {
			if (checkBox[i].isSelected() == true) {
				tmDao.setYes(point, trainername, date, time[i]);
			} else {
				tmDao.setNo(point, trainername, date, time[i]);
			}
			CommonService.msg("저장 완료");
		}

	}

	public void getSchedule() {
		CheckBox[] checkBox = { time7, time9, time11, time13, time15, time17, time19, time21, time23 };
		String[] YesNo = tmService.getYesNo(point, trainername, date, tmDto);

		for (int i = 0; i < checkBox.length; i++) {
			if (YesNo[i].equals("y")) {
				// 체크박스 체크된 상태로 출력
				checkBox[i].setSelected(true);
			} else if (YesNo[i].equals("n")) {
				// n이면 회원 이름 라벨에 넣어주는 메서드
				Label[] label = { name7, name9, name11, name13, name15, name17, name19, name21, name23 };
				String[] PTmembers = tmService.getMatchMemeber(point, trainername, date, tmDto);

				for (int j = 0; j < label.length; j++) {
					label[i].setText(PTmembers[i]);
				}
				checkBox[i].setSelected(false);
			}
		}
	}

	public void setSchedule() {
		tmService.newScheduleInsert(point, trainername, date);
		System.out.println("DB에 새로운 스케줄 row 생성됨");
	}
}
