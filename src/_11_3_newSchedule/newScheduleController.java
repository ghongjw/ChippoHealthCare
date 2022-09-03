package _11_3_newSchedule;

import _0_main.CommonService;
import _0_main.Opener;
import _11_0_TrainManagement.TMcontroller;
import javafx.scene.Parent;

public class newScheduleController {
	private Opener opener;
	private Parent newScheduleform;
	private TMcontroller tmCon;

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	public void setnewScheduleform(Parent newScheduleform) {
		this.newScheduleform = newScheduleform;
	}

	// 스케줄 생성 창에서 '예' 버튼 누르면 동작하는 메서드
	public void yesProc() {
		tmCon = opener.getTmCon();
		tmCon.setSchedule();
		CommonService.msg("스케줄 생성 완료");
		CommonService.windowsClose(newScheduleform);
	}

	// 스케줄 생성 창에서 '아니오' 버튼 누르면 동작하는 메서드
	public void noProc() {
		CommonService.windowsClose(newScheduleform);
	}

}
