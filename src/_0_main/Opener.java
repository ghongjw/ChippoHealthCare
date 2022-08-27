package _0_main;

import java.text.SimpleDateFormat;
import java.util.Date;

import _3_UserMain.UMController;
import _3_UserMain.UMService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Opener {
	private Stage primaryStage;
	
	private String id,name;
	

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	//유저메인화면 띄우기
	public void umOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("usermain.fxml"));
		
		try {
			Parent umform = loader.load();
		
			Scene scene = new Scene(umform);
			
			primaryStage.setTitle("유저 메인 화면");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			CommonService.msg("유저 메인 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}
	
	}
	
	//이용권 구매 화면띄우기
		public void PcOpen() {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("perchase.fxml"));
			try {
				Parent pcForm = loader.load();

				Scene scene = new Scene(pcForm);
				primaryStage.setTitle("이용권 구매 화면");
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (Exception e) {
				CommonService.msg("이용권 구매 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
				e.printStackTrace();
			}
	
	}
		//PT예약페이지띄우기
		public void boOpen() {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("perchase.fxml"));
			try {
				Parent boForm = loader.load();

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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("perchase.fxml"));
			try {
				Parent rcForm = loader.load();

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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("perchase.fxml"));
			try {
				Parent isForm = loader.load();

				Scene scene = new Scene(isForm);
				primaryStage.setTitle("운동 기록 화면");
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (Exception e) {
				CommonService.msg("운동 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
				e.printStackTrace();
			}
	
	}
		//INBODY 입력창 띄우기
				public void inbodyInsertOpen() {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("perchase.fxml"));
					try {
						Parent irForm = loader.load();

						Scene scene = new Scene(irForm);
						primaryStage.setTitle("운동 기록 화면");
						primaryStage.setScene(scene);
						primaryStage.show();
					} catch (Exception e) {
						CommonService.msg("운동 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
						e.printStackTrace();
					}
			
			}
				//회원정보 수정(패스워드 확인창)
				public void userInfoUpdateConfirmPwOpen() {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("perchase.fxml"));
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
				FXMLLoader loader = new FXMLLoader(getClass().getResource("perchase.fxml"));
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
			
		
}
