package _22_findId;

import java.util.Random;

import _0_main.CommonService;
import _0_main.Opener;

public class FindIDService {
	FindIdDAO findIdDao;
	Opener opener;
	String confirmtest;
	private String findId;

	public boolean getid(String name, String moblie,Opener opener) {
		String tmp = "입력 정보가 없습니다";
		findIdDao = new FindIdDAO();
		this.findId = findIdDao.getIDformname(name,moblie);
		if(findIdDao.getIDformname(name, moblie).equals("")) {
			CommonService.msg("입력정보를 확인해 주세요");
		}else 
		{int ran = 0;
		Random r= new Random();
		for(int i = 0;i<5;i++) {
			ran = ran*10;
			int random = r.nextInt(10)+1;
			ran = ran+random;
		}confirmtest=Integer.toString(ran);
		CommonService.msg("인증번호는 : " + confirmtest + " 입니다. ");
		return true;
		}return false;
	}
	public String getConfirmtest() {
		return confirmtest;
	}
	public String getId() {
		return findId;
	}
}
