package _0_main;

import java.io.IOException;

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

	private String id,name;

	private UMController umCon;
	private UMLogoutController umLougoutCon;
	private PcController pcCon;
	private PcConfirmController pcconfirmCon;
	private Opener opener;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	//유저메인화면 띄우기
	public void umOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("usermain.fxml"));

		try {
			Parent umform = loader.load();

			umCon = loader.getController();
			umCon.setOpener(this);
			id=umCon.getuserId();
			name=umCon.getuserName();
			Scene scene = new Scene(umform);
			primaryStage.setTitle("유저 메인 화면");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			CommonService.msg("유저 메인 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}

	}
	//로그아웃 확인 페이지
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

	//이용권 구매 화면띄우기
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
	//결제창 띄우기
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
	//PT예약페이지띄우기
	public void boOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("book.fxml"));
		try {
			Parent boForm = loader.load();
			BoController boController = loader.getController();
			boController.setOpener(this);
			boController.getUserId(id);
			boController.getUserName(name);
			//boController.setboconForm(boForm);
			Scene scene = new Scene(boForm);
			
			
			primaryStage.setTitle("피티 예약 화면");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			CommonService.msg("피티예약 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}

	}
	//운동 기록 페이지띄우기
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
	//INBODY 조회창 띄우기
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
	//INBODY 입력창 띄우기
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
	//회원정보 수정(패스워드 확인창)
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
	//회원정보 수정
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
	
	//회원 아이디 가져오기
	public String getId() {
		return id;
	}
	public void setOpener(Opener opener) {
		this.opener = opener;
	}



}
