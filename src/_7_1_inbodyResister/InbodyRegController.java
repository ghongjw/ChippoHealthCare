package _7_1_inbodyResister;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.CommonService;
import _0_main.Opener;
import _3_UserMain.UMController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class InbodyRegController implements Initializable {

	@FXML
	private TextField height;
	@FXML
	private TextField age;
	@FXML
	private TextField weight;
	@FXML
	private TextField musle;
	@FXML
	private TextField fat;
	@FXML
	private TextField fatper;
	@FXML
	private TextField bmi;

	@FXML
	private ComboBox<String> year;
	@FXML
	private ComboBox<String> month;
	@FXML
	private ComboBox<String> day;

	@FXML
	private Button back;
	@FXML
	private Button add;

	private InbodyRegService inbodyservice;
	private InbodyRegDTO inbodyDTO;

	private Opener opener;

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	@Override
	public void initialize(URL location, ResourceBundle resosurce) {
		inbodyservice = new InbodyRegService();

		year.getItems().addAll("2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025");

		month.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");

		day.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
				"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");

	}

	// 등록 버튼 클릭시 호출
	public void addProc() {

		System.out.println(UMController.staticId);
		inbodyservice.inbodyResisterProc(year, month, day, height, age, weight, musle, fat, fatper, bmi,
				UMController.staticId);

		CommonService.msg("등록되었습니다.");

		opener.inbodySelectOpen();

	}

	public void backproc() {

		opener.inbodySelectOpen();

	}

}
