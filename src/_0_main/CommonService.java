package _0_main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import _3_UserMain.UMLogoutController;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class CommonService {
	static String stryear;
	static String strmonth;
	static String strday;
	static int todayYear;
	static int todayMonth;
	static int todayDay;
	static int logout;
	

	public static void msg(String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(content);
		alert.show();
	}

	public static void windowsClose(Parent form) {
		Stage stage = (Stage) form.getScene().getWindow();
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

		todayYear = Integer.parseInt(stryear);
		todayMonth = Integer.parseInt(strmonth);
		todayDay = Integer.parseInt(strday);
	}

	public static String[] dateArr(String date) {
		String[] dateArr = { date };
		return dateArr;
	}

	// test용 //
//	public static void terminate(WindowEvent evt) {
//		Alert alert = new Alert(AlertType.CONFIRMATION);
//		alert.setTitle("프로그램 종료");
//		alert.setHeaderText("잠깐! 프로그램을 종료하시겠습니까?");
//		alert.setContentText("OK 버튼 클릭 시 프로그램이 종료됩니다.");
//		Optional<ButtonType> result = alert.showAndWait();
//		if (result.get() == ButtonType.OK) {
//			UmLougoutCon.ex();
//		} else if (result.get() == ButtonType.CANCEL) {
//			evt.consume();
//		}
//	}
	

	
}
