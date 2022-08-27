package _3_UserMain;

import java.net.URL;
import java.util.ResourceBundle;

import _0_main.Opener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class UMController implements Initializable{
	@FXML private Label umIDLabel;
	@FXML private Label umNameLabel,umNameLabel2;
	@FXML private Label umLastday;
	@FXML private Label umPtLabel;
	@FXML private Label umYear;
	@FXML private Label umMonth;
	@FXML private Button umgoToUiButton;
	@FXML private Button umBackButton;
	@FXML private Button umLogoutButton;
	@FXML private Button umpreviousMonth;
	@FXML private Button umNextMonth;
	@FXML private Label sDay01,sDay02,sDay03,sDay04,sDay05,sDay06,sDay07,sDay08,sDay09,sDay10;
	@FXML private Label sDay11,sDay12,sDay13,sDay14,sDay15,sDay16,sDay17,sDay18,sDay19,sDay20;
	@FXML private Label sDay21,sDay22,sDay23,sDay24,sDay25,sDay26,sDay27,sDay28,sDay29,sDay30;
	@FXML private Label sDay31,sDay32,sDay33,sDay34,sDay35;
	@FXML private Label ptReserve01,ptReserve02,ptReserve03,ptReserve04,ptReserve05,ptReserve06,ptReserve07,ptReserve08,ptReserve09,ptReserve10;
	@FXML private Label ptReserve11,ptReserve12,ptReserve13,ptReserve14,ptReserve15,ptReserve16,ptReserve17,ptReserve8,ptReserve19,ptReserve20;
	@FXML private Label ptReserve21,ptReserve22,ptReserve23,ptReserve24,ptReserve25,ptReserve26,ptReserve27,ptReserve28,ptReserve29,ptReserve30;
	@FXML private Label ptReserve31,ptReserve32,ptReserve33,ptReserve34,ptReserve35;
	@FXML private Button umGoTOPerchase;
	@FXML private Button umGoTOBo;
	@FXML private Button umGoToRc;
	@FXML private Button umGoToInboby;

	//서비스불러오기
	private UMService umService;
	//창 불러오기
	private Opener opener;
	private String userId;
	private String userName;
	
	

	private int year,month,day;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	public void setOpener(Opener opener) {
		this.opener = opener;
	}
	//서비스에서 아이디값 호출
	public void setIdLabel() {
		userId=umService.getId();
		umIDLabel.setText(userId);
	}
	//서비스 에서 이름 호출 후 라벨에 표시
	public void setNameLabel() {
		userName=umService.getName();
		umNameLabel.setText(userName);
		umNameLabel2.setText(userName);
	}
	//서비스에서 헬스 이용 마지막 날 호출 후 라벨에 표시
	public void umLastday() {
		umPtLabel.setText(umService.getLastDay());
	}
	//서비스에서 헬스 피티이용수 호출 후 라벨에 표시
	public void umPtLabel() {
		umPtLabel.setText(umService.getPTCount());
	}

	public void umLogoutButtonProc() {
		//로그아웃 하시겠습니까
		//welcome화면으로 가기
	}

	public void setUmYearLabel() {
		String year = opener.getYear();
		umYear.setText(year);
		this.year=Integer.parseInt(year);
	}
	//opener에서 그 날의 월을 가져온 후 라벨에 효시
	public void setUmMonthLabel() {
		String month = opener.getMonth();
		umMonth.setText(month);
		this.month=Integer.parseInt(month);
	}
	public void umpreviousMonthProc() {
		if(month==0) {
			month=12;
			year--;
		}
		else month--;

	}
	public void umNextMonthProc() {
		if(month==13) {
			month=1;
			year++;
		}
		else month++;
	}
	//버튼 클릭으로 회원정보 수정 페이지로 전환
	public void umgoToUiButtonProc() {
		opener.userInfoUpdateConfirmPwOpen();
	}
	//버튼 클릭으로 이용권 구매페이지로 전환
	public void umGoTOPerchaseProc() {
		opener.PcOpen();
	}
	//버튼 클릭으로 PT예약페이지로 전환
	public void umGoTOBoProc() {
		opener.boOpen();
	}
	//버튼 클릭으로 회원정보 수정 페이지로 전환
	public void umGoToInbobyProc() {
		opener.inbodySelectOpen();
	}
}
