package _0_main;

import java.io.IOException;

import _0_welService.WelController;
import _10_Manager.MController;
import _1_login.LoginController;
import _201_agreement.AgreementController;
import _21_IDPW.IDPWController;
import _22_findId.FindIdController;
import _23_findpw.FindPwController;
import _2_register.RegController;
import _3_UserMain.UMController;
import _3_UserMain.UMLogoutController;
import _4_perchase.PcConfirmController;
import _4_perchase.PcController;
import _5_book.BoController;
import _6_Record.RcController;
import _9_UserPtUpdate.Upcontroller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Opener {
	private Stage primaryStage;

	private String id;
	private String name;
	private String login;
	private String expireYear;
	private String expireMonth;
	private String expireDay;
	private String ptcount;

	
	private UMController umCon;
	private UMLogoutController umLougoutCon;
	private PcController pcCon;
	private PcConfirmController pcconfirmCon;
	private Opener opener;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	// welcome page오픈
	public void welcomeOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Welcome.fxml"));

		Opener opener = new Opener();

		opener.setPrimaryStage(primaryStage);
		opener.setOpener(opener);

		try {
			Parent Welcome = loader.load();
			WelController WelCon = loader.getController();
			WelCon.setOpener(opener);

			Scene scene = new Scene(Welcome);
			primaryStage.setTitle("Welcome");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 로그인 화면
	public void Login() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));

		try {
			Parent Login = loader.load();
			LoginController logincon = loader.getController();
			logincon.setOpener(opener);

			Scene scene = new Scene(Login);
			primaryStage.setTitle("로그인 화면");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void idpwOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("idPw.fxml"));
		try {
			Parent idPw = loader.load();
			IDPWController idpwCon = loader.getController();
			idpwCon.setIdPw(idPw);
			idpwCon.setOpener(opener);
			Scene scene = new Scene(idPw);

			primaryStage.setTitle("아이디/비밀번호 찾기");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			CommonService.msg("아이디 비번 찾기 창에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}
	}

	public void Findid0Open() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FindId0.fxml"));
		try {
			Parent FindId0 = loader.load();
			FindIdController fiCon = loader.getController();

			fiCon.setOpener(opener);

			Scene scene = new Scene(FindId0);
			Stage Findid0Stage = new Stage();
			Findid0Stage.setTitle("아이디 찾기");
			Findid0Stage.setScene(scene);
			Findid0Stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Findpw0Open() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FindPw0.fxml"));
		try {
			Parent FindPw0 = loader.load();
			FindPwController fpCon = loader.getController();

			fpCon.setOpener(opener);

			Scene scene = new Scene(FindPw0);
			Stage FindPw0Stage = new Stage();
			FindPw0Stage.setTitle("비밀번호 찾기");
			FindPw0Stage.setScene(scene);
			FindPw0Stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void FindId1Open() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FindId1.fxml"));
		try {
			Parent FindId1 = loader.load();

			FindIdController fiCon = loader.getController();
			fiCon.setOpener(opener);
			Scene scene = new Scene(FindId1);
			Stage Findid1Stage = new Stage();

			Findid1Stage.setTitle("아이디 찾기");
			Findid1Stage.setScene(scene);
			Findid1Stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Findpw1Open() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FindPw1.fxml"));
		try {
			Parent Findpw1 = loader.load();

			FindPwController fpCon = loader.getController();
			fpCon.setOpener(opener);
			Scene scene = new Scene(Findpw1);
			Stage Findpw1Stage = new Stage();

			Findpw1Stage.setTitle("비밀번호 찾기");
			Findpw1Stage.setScene(scene);
			Findpw1Stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void agreementOpen() {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("Agreement.fxml"));
		System.out.println("lo"+loader);
		try {
			Parent Agreement = loader.load();
			AgreementController agreeCon = loader.getController();
			agreeCon.setRegister(Agreement);
			agreeCon.setOpener(opener);
			
			Scene scene = new Scene(Agreement);
			Stage agreeStage = new Stage();

			agreeStage.setTitle("취뽀 회원 동의");
			agreeStage.setScene(scene);
			agreeStage.show();
		} catch (Exception e) {
			CommonService.msg("회원 가입 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}

	}

	public void registerOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Register.fxml"));

		try {
			Parent Register = loader.load();

			RegController regCon = loader.getController();
			regCon.setRegister(Register);
			regCon.setOpener(opener);

			Scene scene = new Scene(Register);
			Stage regStage = new Stage();

			regStage.setTitle("취뽀 회원 가입");
			regStage.setScene(scene);
			regStage.show();
		} catch (Exception e) {
			CommonService.msg("회원 가입 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}
	}

	// 유저메인화면 띄우기
	public void umOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Usermain.fxml"));

		try {
			Parent umform = loader.load();
			umCon = loader.getController();
			//umCon.setOpenerinfo(opener,id,name,login,expireYear,expireMonth,expireDay,ptcount);
			umCon.setOpener(opener);
			umCon.setOpenerinfo(opener, id, name);
			Scene scene = new Scene(umform);

			primaryStage.setTitle("유저 메인 화면");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			CommonService.msg("유저 메인 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}

	}

	// 로그아웃 확인 페이지
	public void logoutPg() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("logout.fxml"));
		Parent logoutForm;
		try {
			logoutForm = loader.load();
			umLougoutCon = loader.getController();
			umLougoutCon.setumConfirmForm(logoutForm);
			umLougoutCon.setUmController(umCon);
			umLougoutCon.setumLougoutCon(umLougoutCon);
			umLougoutCon.setOpener(this);
			umLougoutCon.setid(id);

			Scene scene = new Scene(logoutForm);
			Stage pcStage = new Stage();

			pcStage.setTitle("로그아웃 하시겠습니까?");
			pcStage.setScene(scene);
			pcStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 이용권 구매 화면띄우기
	public void PcOpen() {
		System.out.println("여기");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("perchase.fxml"));
		try {
			Parent pcForm = loader.load();

			pcCon = loader.getController();
			pcCon.setOpener(this);
			pcCon.setpcController(pcCon);
			Scene scene = new Scene(pcForm);

			primaryStage.setTitle("이용권 구매 화면");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			CommonService.msg("이용권 구매 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}
	}

	// 결제창 띄우기
	public void comfirmPc() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Perchase2.fxml"));
		Parent conPcForm;
		try {
			conPcForm = loader.load();
			pcconfirmCon = loader.getController();
			pcconfirmCon.setpcConfirmForm(conPcForm);
			pcconfirmCon.setPcController(pcCon);
			pcconfirmCon.setpcConfirmController(pcconfirmCon);
			pcconfirmCon.setOpener(this);

			Scene scene = new Scene(conPcForm);
			Stage pcStage = new Stage();

			pcStage.setTitle("결제하시겠습니까?");
			pcStage.setScene(scene);
			pcStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// PT예약페이지띄우기
	public void boOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("book.fxml"));
		try {
			Parent boForm = loader.load();
			BoController boController = loader.getController();
			boController.setOpener(this);
			boController.getUserId(id);
			boController.getUserName(name);
			// boController.setboconForm(boForm);
			Scene scene = new Scene(boForm);

			primaryStage.setTitle("피티 예약 화면");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			CommonService.msg("피티예약 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}

	}

	// 운동 기록 페이지띄우기
	public void rcOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("record.fxml"));
		try {
			Parent rcForm = loader.load();
			RcController boController = loader.getController();
			boController.setOpener(this);
			boController.setId(id);
			boController.setName(name);
			Scene scene = new Scene(rcForm);
			primaryStage.setTitle("운동 기록 화면");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			CommonService.msg("운동 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}
	}

	// INBODY 조회창 띄우기
	public void inbodySelectOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("inbodySelect.fxml"));
		try {
			Parent isForm = loader.load();

			Scene scene = new Scene(isForm);
			primaryStage.setTitle("인바디 화면");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			CommonService.msg("인바디 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}
	}

	// INBODY 입력창 띄우기
	public void inbodyInsertOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("InbodyRegister.fxml"));
		try {
			Parent irForm = loader.load();

			Scene scene = new Scene(irForm);
			primaryStage.setTitle("인바디 기록 화면");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			CommonService.msg("인바디 기록 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}

	}

	// 회원정보 수정(패스워드 확인창)
	public void userInfoUpdateConfirmPwOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("UserInfoUpdate1.fxml"));
		try {
			Parent uicForm = loader.load();
			Scene scene = new Scene(uicForm);
			primaryStage.setTitle("회원정보 비밀번호 확인 화면");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			CommonService.msg("회원정보 비밀번호 확인 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}

	}

	// 회원정보 수정
	public void userInfoUpdateOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("UserInfoUpdate2.fxml"));
		try {
			Parent uiForm = loader.load();
			Scene scene = new Scene(uiForm);
			primaryStage.setTitle("회원정보 수정 화면");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			CommonService.msg("//회원정보 수정화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}
	}

	public void userPTUpdateOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("userPTUpdate.fxml"));
		try {
			Parent pUForm = loader.load();
			Upcontroller upcontroller = loader.getController();
			upcontroller.setOpener(this);
			upcontroller.getUserId(id);
			upcontroller.getUserName(name);
			Scene scene = new Scene(pUForm);
			primaryStage.setTitle("PT 수정 화면");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			CommonService.msg("//회원정보 수정화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}
	}

	public void mmOpen() { // ManagementMain
		FXMLLoader loader = new FXMLLoader(getClass().getResource("M.fxml"));
		try {
			Parent mmform = loader.load();
			MController mCon = loader.getController();
			mCon.setOpener(opener);

			Scene scene = new Scene(mmform);
			primaryStage.setTitle("관리자 메인 화면");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			CommonService.msg("관리자 메인 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}

	}

	// 회원 아이디 가져오기
	public String getId() {
		return id;
	}

	// 회원 아이디 가져오기
	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	// 회원 아이디 가져오기
	public void setName(String name) {
		this.name = name;
	}

	public void setOpener(Opener opener) {
		this.opener = opener;
	}
	public Opener getOpener() {
		return opener;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public void setExpireYear(String expireYear) {
		this.expireYear = expireYear;
	}

	public void setExpireMonth(String expireMonth) {
		this.expireMonth = expireMonth;
	}

	public void setExpireDay(String expireDay) {
		this.expireDay = expireDay;
	}

	public void setPtcount(String ptcount) {
		this.ptcount = ptcount;
	}
}
