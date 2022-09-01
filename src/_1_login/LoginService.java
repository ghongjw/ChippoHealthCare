package _1_login;

import _0_main.CommonService;
import _0_main.Opener;

public class LoginService {
	private LoginDAO loginDao;
	private LoginDTO loginDto;
	private String userId;
	private String userName;
	private Opener opener;
	private String userExpireYear;
	private String userExpireMonth;
	private String userExpireDay;
	private String userPtcount;
	private String userLogin;

	public LoginService() {
		loginDao = new LoginDAO();
		loginDto = loginDao.getLoginDto();
	}

	public void loginset(String inputId, String inputPw, Opener opener) {
		this.opener = opener;
		System.out.println("login" + inputId + inputPw);
		boolean logincheck = loginDao.selectIdInfo(inputId, inputPw);
		if (inputId.equals("") || inputPw.equals("")) {
			CommonService.msg("아이디 혹은 패스워드를 입력 해 주세요");
		}

		else if (!logincheck) {
			CommonService.msg("입력정보가 없습니다.");

		}

		else if (loginDto.getLogin().equals("y")) {
			CommonService.msg("이미 로그인 된 계정입니다.");
		} else if (logincheck) {
			if (inputId.equals("admin") && inputPw.equals("password")) {
				opener.mmOpen();
			} else {

				loginDao.setLogedIn(inputId);
				userId = loginDto.getId();
				userName = loginDto.getName();
				userExpireYear = loginDto.getExpireYear();
				userExpireMonth = loginDto.getExpireMonth();
				userExpireDay = loginDto.getExpireDay();
				userPtcount = loginDto.getPtcount();
				userLogin = loginDto.getLogin();

				opener.setId(userId);
				opener.setName(userName);
				opener.setLogin(userLogin);
				opener.setExpireYear(userExpireYear);
				opener.setExpireMonth(userExpireMonth);
				opener.setExpireDay(userExpireDay);
				opener.setPtcount(userExpireDay);

				opener.umOpen();
			}
		}
		return;
	}

	public LoginDAO getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDAO loginDao) {
		this.loginDao = loginDao;
	}

	public LoginDTO getLoginDto() {
		return loginDto;
	}

	public void setLoginDto(LoginDTO loginDto) {
		this.loginDto = loginDto;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
