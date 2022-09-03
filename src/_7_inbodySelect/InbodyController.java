package _7_inbodySelect;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import _0_main.Opener;
import _3_UserMain.UMController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

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
	@FXML
	private VBox info;

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
			InbodyDTO datesDto = new InbodyDTO();
			datesDto = dates.get(i);
			datepick.getItems().add(datesDto.getDate());
			System.out.println(datesDto.getDate());
		}

		datepick.valueProperty().addListener(new ChangeListener<String>() {
			
			@Override
			public void changed(ObservableValue ov, String t, String t1) {

				String date = t1;
				System.out.println(date);
				InbodyDAO dao = new InbodyDAO();

				InbodyDTO in = dao.selectdate(date, UMController.staticId);

			
				height.setText(in.getHeight());
				age.setText(in.getAge());

				weight.setText(in.getWeight());
				musle.setText(in.getMusle());
				fat.setText(in.getFat());
				fatper.setText(in.getFatper());
				bmi.setText(in.getBmi());
			}

		});

	}

	public void button() {

//		System.out.print("날짜 : ");
//		String date = in.next();
//		inbodyservice.selectdate(date);

	}

	public void inbodyadd() {

		opener.inbodyInsertOpen();
	}

	public void back() {

		opener.umOpen();

	}
}
