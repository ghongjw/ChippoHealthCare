package _11_0_TrainManagement;

import _0_main.CommonService;
import _0_main.Opener;

public class TMcontroller {
	private Opener opener;

	// 트레이너 관리 화면에서 뒤로가기 버튼 누르면 동작하는 메서드
	public void backProc() {
		opener.mmOpen();
	}

	// 트레이너 관리 화면에서 logo 누르면 동작하는 메서드
	public void homeProc() {
		opener.mmOpen();
	}

	// 트레이너 관리 화면에서 등록 버튼 누르면 동작하는 메서드
	public void regProc() {
		opener.rtOpen();
	}

	// 트레이너 관리 화면에서 삭제 버튼 누르면 동작하는 메서드
	public void delProc() {
		opener.delOpen();
	}

	// 트레이너 관리 화면에서 지점 선택하면 해당 트레이너 바뀌는 메서드
	public void pointProc() { // service로 가야하나?

	}

	// 트레이너 관리 화면에서 트레이너 선택하면 해당 datepicker 데이터 바뀌는 메서드
	public void trainerProc() {
	}

	// 트레이너 관리 화면에서 datepicker 선택하면 저장된(DB) 스케줄표(체크유무) 호출되는 메서드
	public void dateProc() {
	}

	// 트레이너 관리 화면에서 저장 버튼 누르면 동작하는 메서드
	public void saveProc() {
		CommonService.msg("저장 완료");

	}
}
