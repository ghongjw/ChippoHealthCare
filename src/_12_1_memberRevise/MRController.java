package _12_1_memberRevise;

import _0_main.CommonService;
import _0_main.Opener;

public class MRController {
	private Opener opener;

	// 회원 정보 수정 화면에서 뒤로가기 버튼 누르면 동작하는 메서드
	public void backProc() {
		opener.msOpen();
	}

	// 회원 정보 수정 화면에서 logo 누르면 동작하는 메서드
	public void homeProc() {
		opener.mmOpen();
	}

	// 회원 정보 수정 화면에서 등록 버튼 누르면 동작하는 메서드
	public void searchProc() {

		CommonService.msg("저장 완료");
	}

}
