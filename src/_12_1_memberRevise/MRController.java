package _12_1_memberRevise;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import _0_main.CommonService;
import _0_main.Opener;
import _12_0_memberSearch.MSController;
import _12_0_memberSearch.MSDAO;
import _12_0_memberSearch.MSDTO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class MRController implements Initializable {
	@FXML
	private TextField name;
	@FXML
	private TextField age;
	@FXML
	private TextField phone;
	@FXML
	private TextField purpose;
	@FXML
	private TextField days;
	@FXML
	private TextField pt;
	@FXML
	private RadioButton man;
	@FXML
	private RadioButton woman;
	@FXML
	private ComboBox point;

	private Opener opener;
	private String getpoint;
	private String oldName;

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	// 회원 정보 수정 화면에서 뒤로가기 버튼 누르면 동작하는 메서드
	public void backProc() {
		opener.msOpen();
	}

	// 회원 정보 수정 화면에서 logo 누르면 동작하는 메서드
	public void homeProc() {
		opener.mmOpen();
	}

	// 회원 정보 수정 화면에서 등록 버튼 누르면 동작하는 메서드
	public void saveProc() {
		MRDTO mrDto = new MRDTO();
		String[] expiryDate = days.getText().split("-");
		int expire_year = Integer.parseInt(expiryDate[0]);
		int expire_month = Integer.parseInt(expiryDate[1]);
		int expire_day = Integer.parseInt(expiryDate[2]);

		mrDto.setName(name.getText());
		if (man.isSelected() == true) {
			mrDto.setGender("남");
		} else if (woman.isSelected() == true) {
			mrDto.setGender("여");
		}
		mrDto.setAge(age.getText());
		mrDto.setPhone(phone.getText());
		mrDto.setBranch(getpoint);
		mrDto.setPurpose(purpose.getText());
		mrDto.setExpire_year(expire_year);
		mrDto.setExpire_month(expire_month);
		mrDto.setExpire_day(expire_day);
		mrDto.setPt(Integer.parseInt(pt.getText()));
		mrDto.setOldName(oldName);

		MRDAO mrDao = new MRDAO();

		mrDao.update(mrDto);

		CommonService.msg("저장 완료");
		opener.msOpen();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		MSController msCon = new MSController();
		msCon.getSelectName(); // 선택한 사람 이름 가져옴
		MSDAO msDao = new MSDAO();
		ArrayList<MSDTO> msDtoList = msDao.getMemberInfo(msCon.getSelectName());
		MSDTO msDto = new MSDTO();
		msDto = msDtoList.get(0);

		name.setText(msDto.getName());
		oldName = msDto.getName();
		if (msDto.getGender().equals("남")) {
			man.setSelected(true);
		} else {
			woman.setSelected(true);
		}
		age.setText(Integer.toString(msDto.getAge()));
		phone.setText(msDto.getMobile());
		point.setValue(msDto.getBranch());
		days.setText(msDto.getExpiryDate());
		purpose.setText(msDto.getPurposse());
		pt.setText(Integer.toString(msDto.getPtcount()));

		point.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				getpoint = t1;
			}
		});
	}

}
