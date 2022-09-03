package _8_1_UserInfoUpdateB;

import _0_main.CommonService;
import _0_main.Opener;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UibService {

	private UibDAO uibdao = new UibDAO();

	public void userinfoupdateProc(TextField pw, TextField pwcon, TextField name, TextField email, ComboBox emailbox,
			TextField mobile, TextField address, RadioButton men, RadioButton women, ComboBox point, TextArea purpose,
			String id) {

		UibDTO uibdto = new UibDTO();

		if (men.isSelected() == true) {
			uibdto.setGender("남");

		} else if (women.isSelected() == true) {
			uibdto.setGender("여");
		}
		System.out.println(uibdto.getGender());
		uibdto.setPw(pw.getText());
		uibdto.setPwcon(pwcon.getText());
		uibdto.setName(name.getText());
		uibdto.setEmail(email.getText());
		uibdto.setEmailbox(emailbox.getId());
		uibdto.setMobile(mobile.getText());
		uibdto.setAddress(address.getText());
		uibdto.setPurpose(purpose.getText());
		uibdto.setPoint(point.getValue().toString());

		String addemail = "";

		addemail = email.getText().toString() + "@" + emailbox.getValue().toString();
		uibdto.setAddemail(addemail);

		uibdao.update(uibdto, id);

	}

}
