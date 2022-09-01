package _12_0_memberSearch;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.Opener;
import javafx.fxml.Initializable;

public class MSController implements Initializable{
	private Opener opener;
	
	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	// 회원 검색 화면에서 뒤로가기 버튼 누르면 동작하는 메서드
	public void backProc() {
		opener.mmOpen();
	}

	// 회원 검색 화면에서 logo 누르면 동작하는 메서드
	public void homeProc() {
		opener.mmOpen();
	}

	// 회원 검색 화면에서 검색 버튼 누르면 동작하는 메서드
	public void searchProc() {

	}

	// 회원 검색 화면에서 이름(or 해당 줄) 누르면 동작하는 메서드
	public void ReviseProc() {

		opener.reviseOpen();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
