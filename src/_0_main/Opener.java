package _0_main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class Opener {
	private Stage primaryStage;
	private Date date = new Date();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private String regDate = sdf.format(date);
	private String[] DateSplit = regDate.split("-");
	private String year = DateSplit[0];
	private String month = DateSplit[1];
	private String day = DateSplit[2];

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	// 유저메인화면 띄우기
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

	// 이용권 구매 화면띄우기
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

	// PT예약페이지띄우기
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

	// 운동 기록 페이지띄우기
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

	// INBODY 조회창 띄우기
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

	// INBODY 입력창 띄우기
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

	// 회원정보 수정(패스워드 확인창)
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

	// 회원정보 수정
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

	// 10번 관리자 창 띄우기
	public void mmOpen() { // ManagementMain
		FXMLLoader loader = new FXMLLoader(getClass().getResource("M.fxml"));
		try {
			Parent mmform = loader.load();
			Scene scene = new Scene(mmform);
			primaryStage.setTitle("관리자 메인 화면");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			CommonService.msg("관리자 메인 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}

	}

	// 11번 트레이너관리 창 띄우기
	public void tmOpen() { // TrainerManagement
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TM.fxml"));
		try {
			Parent tmform = loader.load();

			Scene scene = new Scene(tmform);

			// 지점 추가
			ListView<String> pointList = (ListView<String>) tmform.lookup("#point");
			pointList.getItems().addAll("영등포점", "창동점", "홍제점", "의정부점", "강남점", "송파점", "분당점", "성수점", "노량진점", "부산점");

			// 트레이너 추가
			// 지점을 선택하면 해당 트레이너들이 나와야함
			// 제대로 접근했는지 모르겠음
			if (pointList.getItems().equals("영등포점")) {
				ListView<String> trainer = (ListView<String>) tmform.lookup("#trainer");
				pointList.getItems().addAll("영등포점1", "영등포점", "영등포점3");
			}

			else if (pointList.getItems().equals("창동점")) {// 제대로 접근했는지 모르겠음
				ListView<String> trainer = (ListView<String>) tmform.lookup("#trainer");
				pointList.getItems().addAll("창동점1", "창동점2", "창동점3");
			}

			else if (pointList.getItems().equals("홍제점")) {// 제대로 접근했는지 모르겠음
				ListView<String> trainer = (ListView<String>) tmform.lookup("#trainer");
				pointList.getItems().addAll("홍제점1", "홍제점2", "홍제점3");
			}

			else if (pointList.getItems().equals("의정부점")) {// 제대로 접근했는지 모르겠음
				ListView<String> trainer = (ListView<String>) tmform.lookup("#trainer");
				pointList.getItems().addAll("의정부점1", "의정부점2", "의정부점3");
			}

			else if (pointList.getItems().equals("강남점")) {// 제대로 접근했는지 모르겠음
				ListView<String> trainer = (ListView<String>) tmform.lookup("#trainer");
				pointList.getItems().addAll("강남점1", "강남점2", "강남점3");
			}

			else if (pointList.getItems().equals("송파점")) {// 제대로 접근했는지 모르겠음
				ListView<String> trainer = (ListView<String>) tmform.lookup("#trainer");
				pointList.getItems().addAll("송파점1", "송파점", "송파점3");
			}

			else if (pointList.getItems().equals("분당점")) {// 제대로 접근했는지 모르겠음
				ListView<String> trainer = (ListView<String>) tmform.lookup("#trainer");
				pointList.getItems().addAll("분당점1", "분당점2", "분당점3");
			}

			else if (pointList.getItems().equals("성수점")) {// 제대로 접근했는지 모르겠음
				ListView<String> trainer = (ListView<String>) tmform.lookup("#trainer");
				pointList.getItems().addAll("성수점1", "성수점2", "성수점3");
			}

			else if (pointList.getItems().equals("노량진점")) {// 제대로 접근했는지 모르겠음
				ListView<String> trainer = (ListView<String>) tmform.lookup("#trainer");
				pointList.getItems().addAll("노량진점1", "노량진점2", "노량진점3");
			}

			else if (pointList.getItems().equals("부산점")) {// 제대로 접근했는지 모르겠음
				ListView<String> trainer = (ListView<String>) tmform.lookup("#trainer");
				pointList.getItems().addAll("부산점1", "부산점", "부산점3");
			}

			primaryStage.setTitle("트레이너관리 화면");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			CommonService.msg("트레이너관리 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}

	}

	// 11-1 트레이너 등록 창 띄우기
	public void rtOpen() { // RegTrainer
		FXMLLoader loader = new FXMLLoader(getClass().getResource("RT.fxml"));
		try {
			Parent rtform = loader.load();
			Scene scene = new Scene(rtform);

			ComboBox<String> pointCombo = (ComboBox<String>) rtform.lookup("#regPoint");
			pointCombo.getItems().addAll("영등포점", "창동점", "홍제점", "의정부점", "강남점", "송파점", "분당점", "성수점", "노량진점", "부산점");

			primaryStage.setTitle("트레이너 등록 화면");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			CommonService.msg("회원검색 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}

	}

	// 11-2 트레이너 삭제 창 띄우기
	public void delOpen() { // delete
		FXMLLoader loader = new FXMLLoader(getClass().getResource("deleteTrainer.fxml"));
		try {
			Parent delform = loader.load();
			Scene scene = new Scene(delform);
			primaryStage.setTitle("트레이너 삭제 화면");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			CommonService.msg("회원검색 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}

	}

	// 12번 회원검색 창 띄우기
	public void msOpen() { // MemberSearch
		FXMLLoader loader = new FXMLLoader(getClass().getResource("memberSearch.fxml"));
		try {
			Parent msform = loader.load();
			Scene scene = new Scene(msform);

			TableView<String> memberTable = (TableView<String>) msform.lookup("#memberList");
			// 이름 검색했을때 해당 이름이 추가돼야하는데 DB랑 연관지어야함

			primaryStage.setTitle("회원검색 화면");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			CommonService.msg("회원검색 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}

	}

	// 12-1 회원 정보 수정 창 띄우기
	public void reviseOpen() { // delete
		FXMLLoader loader = new FXMLLoader(getClass().getResource("memberRevise.fxml"));
		try {
			Parent reviseform = loader.load();
			Scene scene = new Scene(reviseform);

			ComboBox<String> pointCombo = (ComboBox<String>) reviseform.lookup("#point");
			pointCombo.getItems().addAll("영등포점", "창동점", "홍제점", "의정부점", "강남점", "송파점", "분당점", "성수점", "노량진점", "부산점");

			primaryStage.setTitle("회원 정보 수정 화면");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			CommonService.msg("회원검색 화면에 문제가 발생했습니다. 관리자에게 문의하세요.");
			e.printStackTrace();
		}

	}

	public String getYear() {
		return year;
	}

	public String getMonth() {
		return month;
	}

	public String getDay() {
		return day;
	}

}