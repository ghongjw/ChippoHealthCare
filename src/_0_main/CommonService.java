package _0_main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CommonService {
	static String stryear;
	static String strmonth;
	static String strday;
	static int todayYear;
	static int todayMonth;
	static int todayDay;
	
	public static void msg(String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(content);
		alert.show();
	}
	public static void windowsClose(Parent form) {
		Stage stage = (Stage)form.getScene().getWindow();
		stage.close();
	}
	public static void today() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String regDate = sdf.format(date);
		String[] DateSplit = regDate.split("-");
		stryear = DateSplit[0];
		strmonth = DateSplit[1];
		strday = DateSplit[2];

		todayYear=Integer.parseInt(stryear);
		todayMonth=Integer.parseInt(strmonth);
		todayDay=Integer.parseInt(strday);
	}

}
