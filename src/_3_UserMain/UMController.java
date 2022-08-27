package _3_UserMain;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	@FXML private Label sDay1,sDay2,sDay3,sDay4,sDay5,sDay6,sDay7,sDay8,sDay9,sDay10;
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
	private String userId="doremi";
	private String userName="fasora";
	ArrayList<Label> sdays = new ArrayList<Label>();
	
	private int year,month,day;
	private String stryear,strmonth,strday;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		umService=new UMService();
		umService.setId(userId, userName);
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String regDate = sdf.format(date);
		String[] DateSplit = regDate.split("-");
		stryear = DateSplit[0];
		strmonth = DateSplit[1];
		strday = DateSplit[2];

		umYear.setText(stryear);
		this.year=Integer.parseInt(stryear);
		
		umMonth.setText(strmonth);
		this.month=Integer.parseInt(strmonth);
		
		umIDLabel.setText(umService.getId());
		
		umNameLabel.setText(umService.getName());
		umNameLabel2.setText(umService.getName());
		umService.getId();
		
		umLastday.setText(umService.getLastDay());
		umPtLabel.setText(umService.getPTCount());
		
		addSDayLabel();
	}
	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	public void umLogoutButtonProc() {
		//로그아웃 하시겠습니까
		//welcome화면으로 가기
	}

	//달력  연월 과거이동
	public void umpreviousMonthProc() {
		if(month==1) {
			month=12;
			year--;
		}
		else month--;
		umYear.setText(Integer.toString(year));
		umMonth.setText(Integer.toString(month));
	}
	//달력  연월 미래 이동
	public void umNextMonthProc() {
		if(month==12) {
			month=1;
			year++;
		}
		else month++;
		umYear.setText(Integer.toString(year));
		umMonth.setText(Integer.toString(month));
	}
	public void addSDayLabel() {
		sdays.add(sDay1);sdays.add(sDay2);sdays.add(sDay3);sdays.add(sDay4);sdays.add(sDay5);
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
	//버튼 클릭으로 인바디로 전환
	public void umGoToInbobyProc() {
		opener.inbodySelectOpen();
	}
	//운동기록전환
	public void umGoToRcProc() {
		opener.inbodySelectOpen();
	}

}
