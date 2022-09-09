package _11_1_regTrainer;

import java.io.BufferedInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import _0_main.Opener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class RTController implements Initializable {
	@FXML
	private TextField name;
	@FXML
	private TextField age;
	@FXML
	private RadioButton man;
	@FXML
	private RadioButton woman;
	@FXML
	private TextArea spec;
	@FXML
	private ComboBox<String> regPoint; // fx:id와 이름이 같아야함(java.lang.NullPointerException)
	@FXML
	private ImageView uploadImage;
	private Opener opener;
	private RTService RTService;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		RTService = new RTService();
		regPoint.getItems().addAll("영등포점", "창동점", "홍제점", "의정부점", "강남점", "송파점", "분당점", "성수점", "노량진점", "부산점");
	}

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	// 트레이너 등록 화면에서 뒤로가기 버튼 누르면 동작하는 메서드
	public void backProc() {
		opener.tmOpen();

	}

	// 트레이너 등록 화면에서 logo 누르면 동작하는 메서드
	public void homeProc() {
		opener.mmOpen();
	}

	// 구현은 됐고 이미지 경로(url)를 DB에 저장해줘야함
	// 트레이너 등록 화면에서 사진등록 버튼 누르면 동작하는 메서드
	public void regImageProc() {
		// 사진 선택 창
		FileChooser fc = new FileChooser();
		fc.setTitle("이미지 선택");
		fc.setInitialDirectory(new File("C:/"));
		// default 디렉토리 설정        
		// 선택한 파일 정보 추출        
		// 확장자 제한
		ExtensionFilter imgType = new ExtensionFilter("image file", "*.jpg", "*.gif", "*.png");
		fc.getExtensionFilters().add(imgType);
		ExtensionFilter txtType = new ExtensionFilter("text file", "*.txt", "*.doc");
		fc.getExtensionFilters().addAll(imgType, txtType);

		File selectedFile = fc.showOpenDialog(null); // showOpenDialog는 창을 띄우는데 어느 위치에 띄울건지 인자를 받고
														// 그리고 선택한 파일의 경로값을 반환한다.
		System.out.println(selectedFile); // 선택한 경로가 출력된다.

		// 파일을 InputStream으로 읽어옴
		try {
			// 파일 읽어오기
			FileInputStream fis = new FileInputStream(selectedFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			// 이미지 생성하기
			Image img = new Image(bis);
			// 이미지 띄우기
			uploadImage.setImage(img);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	// 트레이너 등록 화면에서 등록 버튼 누르면 동작하는 메서드
	public void regProc() {
		RTService.regProc(name, age, man, woman, spec, regPoint);
		opener.tmOpen();
	}

}
