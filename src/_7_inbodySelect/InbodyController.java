package _7_inbodySelect;

import java.net.URL;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import _0_main.CommonService;
import _0_main.Opener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class InbodyController implements Initializable {

	@FXML
	private Label height;
	@FXML
	private Label age;
	@FXML
	private Label weight;
	@FXML
	private Label musle;
	@FXML
	private Label fat;
	@FXML
	private Label fatper;
	@FXML
	private Label bmi;
	@FXML
	private ComboBox<String> datepick;
	@FXML
	private Button inbodyadd;
	@FXML
	private Button back;
	@FXML
	private Button button;

	private static Scanner in = new Scanner(System.in);

	private InbodyService inbodyservice;

	private Opener opener;

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	@Override
	public void initialize(URL location, ResourceBundle resosurce) {

		inbodyservice = new InbodyService();
		ArrayList<InbodyDTO> dates = inbodyservice.getdate();
		for (int i = 0; i < dates.size(); i++) {
			System.out.println(dates.get(i));
//			datepick.getItems().addAll(dates.get(i));

		}
	}

	public void button() {

		System.out.print("날짜 : ");
		String date = in.next();
		inbodyservice.selectdate(date);

	}

	public void inbodyadd() {

		opener.inbodyInsertOpen();
	}

	public void back() {

		opener.umOpen();

	}
}
