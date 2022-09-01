package _11_2_deleteTrainer;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.CommonService;
import _0_main.Opener;
import _11_0_TrainManagement.TMcontroller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class deleteController {
	@FXML
	private Button yes;
	@FXML
	private Button no;
	@FXML
	private Label name;

	private Opener opener;
	private Parent delform;
	private TMcontroller tmCon;

	public void setOpener(Opener opener) {
		this.opener = opener;
		// trainername을 가져오려는데 NullPointerException 발생
		// tmCon에 TmCon의 참조값을 넣고
		tmCon = opener.getTmCon();
		// TmCon에 있는 getName(trainername 반환하는)메서드를 사용해서
		// name에 setText해줌
		name.setText(tmCon.getName());
	}

	public void setdelform(Parent delform) {
		this.delform = delform;
	}

	// 삭제 창에서 '예' 버튼 누르면 동작하는 메서드
	public void yesProc() {
		
		CommonService.msg("삭제 왼료");
		CommonService.windowsClose(delform);
	}

	// 삭제 창에서 '아니오' 버튼 누르면 동작하는 메서드
	public void noProc() {
		CommonService.windowsClose(delform);
	}

}
