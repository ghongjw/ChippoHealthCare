package _8_1_UserInfoUpdateB;

import _0_main.CommonService;
import _0_main.Opener;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UibService {

	private UibDAO uibdao = new UibDAO();

	public void userinfoupdateProc(PasswordField pw, PasswordField pwcon, TextField name, TextField age,
			TextField email, ComboBox emailbox, TextField mobile, TextField address, RadioButton men, RadioButton women,
			ComboBox point, RadioButton diet, RadioButton competition, RadioButton health, String id) {

		UibDTO uibdto = new UibDTO();

		if (men.isSelected()) {
			uibdto.setGender("남");

		} else if (women.isSelected()) {
			uibdto.setGender("여");
		}

		String tmp = "";

		if (health.isSelected()) {
			tmp += "diet  ";
			
		}

		if(competition.isSelected()) {
			tmp += "competition  ";
		
		}

		if(diet.isSelected()) {
			tmp += "health";
		
		}

		uibdto.setPurpose(tmp);
		System.out.println("uibdto :" + uibdto.getPurpose());
	

//		if(health.isSelected() == true) {
//			uibdto.setHealth("건강관리");
//		}
//		if(diet.isSelected() == true) {
//			uibdto.setDiet(" 다이어트");
//		}
//		if(competition.isSelected() == true) {
//			uibdto.setCompetition(" 대회준비");
//		}
//		
//		uibdto.setPurpose(
//			
//				uibdto.getHealth() + uibdto.getDiet() + uibdto.getCompetition());
//		
//		System.out.println(uibdto.getGender());

		uibdto.setPw(pw.getText());
		uibdto.setPwcon(pwcon.getText());
		uibdto.setName(name.getText());
		uibdto.setEmail(email.getText());
		uibdto.setEmailbox(emailbox.getId());
		uibdto.setMobile(mobile.getText());
		uibdto.setAddress(address.getText());
		uibdto.setAge(age.getText());

		uibdto.setPoint(point.getValue().toString());

		String addemail = "";

		addemail = email.getText().toString() + "@" + emailbox.getValue().toString();
		uibdto.setAddemail(addemail);

//		email.setText(addemail.split("@"));
//		System.out.println(uibdto.getPw());
//		System.out.println(uibdto.getAddemail());
//		System.out.println(uibdto.getMobile());
//		System.out.println(uibdto.getAddress());
//		System.out.println(uibdto.getGender());
//		System.out.println(uibdto.getPoint());
//		System.out.println(uibdto.getPurpose());
//		

		uibdao.update(uibdto, id);

	}

}
