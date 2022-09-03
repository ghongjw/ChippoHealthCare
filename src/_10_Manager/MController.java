package _10_Manager;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.Main;
import _0_main.Opener;
import javafx.fxml.Initializable;

public class MController implements Initializable {
	private Main main;
	private Opener opener;

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	// 관리자 창에서 뒤로가기 버튼 누르면 뒤로 이동하는 메서드
	public void backproc() {
		// 관리자 메인에서 뒤로가기 누르면 로그아웃 할거냐는 창 띄우는거 추가하면 좋을거 같음
		opener.Login();
	}

	// 관리자 창에서 logo 누르면 동작하는 메서드
	public void homeProc() {
//			System.out.println("관리자화면(10) 열기");
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
