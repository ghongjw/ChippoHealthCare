package _11_2_deleteTrainer;

import _0_main.CommonService;
import javafx.scene.Parent;

public class deleteController {
	private Parent delform;
	
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
