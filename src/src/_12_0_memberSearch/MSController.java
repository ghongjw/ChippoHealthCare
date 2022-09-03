package _12_0_memberSearch;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import _0_main.CommonService;
import _0_main.Opener;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MSController implements Initializable {
	@FXML
	private TextField nameTextfield;
	@FXML
	private TableView<Person> memberList;
	@FXML
	private TableColumn<Person, String> name;
	@FXML
	private TableColumn<Person, String> gender;
	@FXML
	private TableColumn<Person, Integer> age;
	@FXML
	private TableColumn<Person, String> mobile;
	@FXML
	private TableColumn<Person, String> branch;
	@FXML
	private TableColumn<Person, String> purpose;
	@FXML
	private TableColumn<Person, String> expiryDate;
	@FXML
	private TableColumn<Person, Integer> PTcount;
	@FXML
	private MSService msService = new MSService();
	private Opener opener;
//	private MSDTO msDto = new MSDTO();
	private static String selectName;

	ObservableList<Person> list = FXCollections.observableArrayList();

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	// 회원 검색 화면에서 뒤로가기 버튼 누르면 동작하는 메서드
	public void backProc() {
		opener.mmOpen();
	}

	// 회원 검색 화면에서 logo 누르면 동작하는 메서드
	public void homeProc() {
		opener.mmOpen();
	}

	public static String getSelectName() {
		return selectName;
	}

	public boolean Empty() {
		MSDTO msDto = new MSDTO();
		msService.getMemberInfo(nameTextfield.getText(), msDto);
		if (msDto.getName() == null)
			// 비어있으면 true 반환
			return true;
		return false;

	}

	// 회원 검색 화면에서 검색 버튼 누르면 동작하는 메서드
	public void searchProc() {
		if (nameTextfield.getText().isEmpty()) {
			memberList.getItems().clear();
			ArrayList<MSDTO> DtoList = msService.getAllData(); // -> List(DTO들 담긴)

			for (int i = 0; i < DtoList.size(); i++) {
				MSDTO msDto = new MSDTO();
				msDto = (DtoList.get(i));
				list.addAll(new Person(new SimpleStringProperty(msDto.getName()),
						new SimpleStringProperty(msDto.getGender()), new SimpleIntegerProperty(msDto.getAge()),
						new SimpleStringProperty(msDto.getMobile()), new SimpleStringProperty(msDto.getBranch()),
						new SimpleStringProperty(msDto.getPurposse()), new SimpleStringProperty(msDto.getExpiryDate()),
						new SimpleIntegerProperty(msDto.getPtcount())));
			}
		} else if (Empty()) {
			CommonService.msg("존재하지 않는 이름입니다. 확인 후 다시 입력해주세요.");
		} else {
			memberList.getItems().clear();
			MSDTO msDto = new MSDTO();
			ArrayList<MSDTO> DtoList = msService.getMemberInfo(nameTextfield.getText(), msDto);

			for (int i = 0; i < DtoList.size(); i++) {
				msDto = (DtoList.get(i));
				list.addAll(new Person(new SimpleStringProperty(msDto.getName()),
						new SimpleStringProperty(msDto.getGender()), new SimpleIntegerProperty(msDto.getAge()),
						new SimpleStringProperty(msDto.getMobile()), new SimpleStringProperty(msDto.getBranch()),
						new SimpleStringProperty(msDto.getPurposse()), new SimpleStringProperty(msDto.getExpiryDate()),
						new SimpleIntegerProperty(msDto.getPtcount())));
			}
		}
	}

	// 회원 검색 화면에서 row 누르면 동작하는 메서드
	public void ReviseProc() {
		// tableview row 더블클릭하면 동작하는 코드
		memberList.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
					StringProperty name = memberList.getSelectionModel().getSelectedItem().getName();
					String stringName = name.toString();
					selectName = stringName.substring(23, 26);
					opener.reviseOpen();
				}
			}
		});
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		name.setCellValueFactory(cellData -> (cellData).getValue().getName());
		gender.setCellValueFactory(cellData -> (cellData).getValue().getGender());
		age.setCellValueFactory(cellData -> (cellData).getValue().getAge().asObject());
		mobile.setCellValueFactory(cellData -> (cellData).getValue().getMobile());
		branch.setCellValueFactory(cellData -> (cellData).getValue().getBranch());
		purpose.setCellValueFactory(cellData -> (cellData).getValue().getPurpose());
		expiryDate.setCellValueFactory(cellData -> (cellData).getValue().getExpiryDate());
		PTcount.setCellValueFactory(cellData -> (cellData).getValue().getPTcount().asObject());

		ArrayList<MSDTO> DtoList = msService.getAllData(); // -> List(DTO들 담긴)

		for (int i = 0; i < DtoList.size(); i++) {
			MSDTO msDto = new MSDTO();
			msDto = (DtoList.get(i));
			list.addAll(new Person(new SimpleStringProperty(msDto.getName()),
					new SimpleStringProperty(msDto.getGender()), new SimpleIntegerProperty(msDto.getAge()),
					new SimpleStringProperty(msDto.getMobile()), new SimpleStringProperty(msDto.getBranch()),
					new SimpleStringProperty(msDto.getPurposse()), new SimpleStringProperty(msDto.getExpiryDate()),
					new SimpleIntegerProperty(msDto.getPtcount())));
		}
		memberList.setItems(list);

	}
}
