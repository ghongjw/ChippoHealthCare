package _21_IDPW;

import _0_main.Opener;
import javafx.scene.Parent;

public class IDPWController {
	private Parent IdPw;
	private Opener opener;

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	public void backButtonProc() {
		opener.Login();
	}

	public void FindId0() {

		opener.Findid0Open();
	}

	public void FindPw0() {

		opener.Findpw0Open();
	}

	public void setIdPw(Parent IdPw) {
		this.IdPw = IdPw;

	}
}
