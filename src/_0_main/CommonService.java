package _0_main;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CommonService {
	public static void msg(String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(content);
		alert.show();
	}
}
