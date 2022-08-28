package _10_Manager;

import _0_main.Main;
import _0_main.Opener;

public class MController {
	private Main main;
	private Opener opener;

	// 관리자 창에서 뒤로가기 버튼 누르면 뒤로 이동하는 메서드
	public void backProc() {
		// 관리자 메인에서 뒤로가기 누르면 로그아웃 할거냐는 창 띄우는거 추가하면 좋을거 같음
		System.out.println("로그인화면 열기");
//		main.start();
	}

	// 관리자 창에서 logo 누르면 동작하는 메서드
	public void homeProc() {
//		System.out.println("관리자화면(10) 열기");
		opener.mmOpen();
	}

	// 관리자 창에서 트레이너관리 버튼 누르면 이동하는 메서드
	public void TMProc() {
		opener.tmOpen();
	}

	// 관리자 창에서 회원검색 버튼 누르면 이동하는 메서드
	public void MSProc() {
		opener.msOpen();
	}

}
