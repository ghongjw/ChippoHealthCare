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
	private Label name7, name9, name11, name13, name15, name17, name19, name21, name23;
	private Opener opener;
	private TMService tmService;
	private TMDTO tmDto = new TMDTO();
	private static String point;
	private static String trainername;
	private static String date;

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
		opener.rtOpen();
	}

	// 트레이너 관리 화면에서 삭제 버튼 누르면 동작하는 메서드
	public void delProc() {
		if (point == null || trainername == null) {
			CommonService.msg("지점 및 트레이너를 선택해주세요.");
		} else
			opener.delOpen();
	}

	// 트레이너 관리 화면에서 스케줄 관리 버튼 누르면 동작하는 메서드
	public void management() {
		opener.scheduleManagementOpen();
	}

	// 트레이너 관리 화면에서 검색 버튼 누르면 동작하는 메서드
	public void searchProc() {
		if (point == null || trainername == null || date == null) {
			CommonService.msg("지점, 트레이너, 날짜를 모두 선택해주세요.");
		} else {
			// 검색 눌렀을 때 DB에 스케줄이 있으면 스케줄표를 가져옴
			if (tmService.ScheduleEmpty(point, trainername, date, tmDto) == true) {
				getSchedule();
				schedulebox.setVisible(true);
			}
			// !! 스케줄 있는 날짜 선택후 스케줄 없는 날짜 선택하면 아래 코드 동작안함
			// if 순서문제는 아님,
			// 선택한 날짜에 DB에 스케줄이 없으면 스케줄이 없다는 창 띄우고 생성하겠냐는 새 창 띄움
			else if (tmService.ScheduleEmpty(point, trainername, date, tmDto) == false) {
				opener.newScheduleOpen();
			}

		}
	}

	public void getSchedule() {
		String[] PTmembers = tmService.getMatchMemeber(point, trainername, date, tmDto);
		Label[] label = { name7, name9, name11, name13, name15, name17, name19, name21, name23 };

		for (int j = 0; j < label.length; j++) {
			label[j].setText(PTmembers[j]);
		}

	}

	public void setSchedule() {
		tmService.newScheduleInsert(point, trainername, date);
//		System.out.println("DB에 새로운 스케줄 row 생성됨");
	}

	public String getName() {
		return trainername;

	}

	public String getPoint() {
		return point;
	}

	public String getDate() {
		return date;
	}
}
