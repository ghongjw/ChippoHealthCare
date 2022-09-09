package _23_findpw;

import java.util.Random;

import _0_main.CommonService;
import _0_main.Opener;

public class FindPWService {
	FindPwDAO findPwDao;
	String confirmtest;
	private String findPw;
	Opener opener;

	public boolean getPw(String name, String mobile, Opener opener, String id) {
		findPwDao = new FindPwDAO();
		this.findPw = findPwDao.getPWformName(name, mobile, id);
		if (findPwDao.getPWformName(name, mobile, id).equals(" ")) {
			CommonService.msg("입력정보를 확인해주세요");
		} else {
			int ran = 0;
			Random r = new Random();
			for (int i = 0; i < 6; i++) {
				ran = ran * 10;
				int random = r.nextInt(10) + 1;
				ran = ran + random;
			}
			confirmtest = Integer.toString(ran);
			CommonService.msg("인증번호는 : " + confirmtest + " 입니다. ");
			return true;
		}
		return false;
	}

	public String getConfirmtest() {
		return confirmtest;
	}

	public String getPw() {
		return findPw;
	}

}
