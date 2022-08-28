package _11_1_regTrainer;

import _0_main.CommonService;
import _0_main.Opener;

public class RTController {
	private Opener opener;

	// 트레이너 등록 화면에서 뒤로가기 버튼 누르면 동작하는 메서드
	public void backProc() {
		opener.tmOpen();

	}

	// 트레이너 등록 화면에서 logo 누르면 동작하는 메서드
	public void homeProc() {
		opener.mmOpen();
	}

	// 트레이너 등록 화면에서 사진등록 버튼 누르면 동작하는 메서드
	public void regImageProc() {
		// 파일 업로드 하는 창 띄우고 불러오기
	}

	// 트레이너 등록 화면에서 등록 버튼 누르면 동작하는 메서드
	public void regProc() {
		// service
		// service
		CommonService.msg("등록 완료");
		opener.tmOpen();
	}

}
