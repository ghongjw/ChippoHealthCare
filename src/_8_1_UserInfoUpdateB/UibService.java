package _8_1_UserInfoUpdateB;

import _0_main.CommonService;
import _0_main.Opener;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class UibService {

	private UibDAO uibdao = new UibDAO();

	public void userinfoupdateProc(TextField pw, TextField pwcon, TextField email, ComboBox emailbox, TextField phone,
			TextField address, RadioButton men, RadioButton women, ComboBox point) {
		UibDTO uibdto = new UibDTO();

		uibdto.setPw(pw.getText());
		uibdto.setPwcon(pwcon.getText());
		uibdto.setEmail(email.getText());
		uibdto.setEmailbox(emailbox.getId());

		uibdto.setPhone(phone.getText());
		uibdto.setGender(men.getText());
		uibdto.setGender(women.getText());		
		uibdto.setAddress(address.getText());
		uibdto.setPoint(point.getValue().toString());

		String addemail = "";

		addemail = email.getText().toString() + "@" + emailbox.getValue().toString();
		uibdto.setAddemail(addemail);
		System.out.println(addemail);
		System.out.println(point.getValue().toString());
		System.out.println(uibdto.getGender());

		if (pw.getText().equals(pwcon.getText()) == true) {

		} else {

			CommonService.msg("비밀번호가 일치하지 않습니다");
			return;

		}

		uibdao.update(uibdto);

	}

}