package _3_UserMain;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
	@FXML private Label sDay31,sDay32,sDay33,sDay34,sDay35,sDay36,sDay37,sDay38,sDay39,sDay40,sDay41,sDay42;
	@FXML private Label ptReserve01,ptReserve02,ptReserve03,ptReserve04,ptReserve05,ptReserve06,ptReserve07,ptReserve08,ptReserve09,ptReserve10;
	@FXML private Label ptReserve11,ptReserve12,ptReserve13,ptReserve14,ptReserve15,ptReserve16,ptReserve17,ptReserve18,ptReserve19,ptReserve20;
	@FXML private Label ptReserve21,ptReserve22,ptReserve23,ptReserve24,ptReserve25,ptReserve26,ptReserve27,ptReserve28,ptReserve29,ptReserve30;
	@FXML private Label ptReserve31,ptReserve32,ptReserve33,ptReserve34,ptReserve35,ptReserve36,ptReserve37,ptReserve38,ptReserve39,ptReserve40,ptReserve41,ptReserve42;
	@FXML private Button umGoTOPerchase;
	@FXML private Button umGoTOBo;
	@FXML private Button umGoToRc;
	@FXML private Button umGoToInboby;

	//서비스불러오기
	private UMService umService;
	private UMDTO umDto;
	//창 불러오기
	private Opener opener;
	private String userId="doremi";
	private String userName="fasora";
	ArrayList<Label> sdays = new ArrayList<Label>();

	private int year,month,day,todayYear,todayMonth,todayDay;
	private String stryear,strmonth,strday;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		umService=new UMService();
		umService.setId(userId, userName);
		umService.today();

		this.year=umService.getTodayYear();
		this.month=umService.getTodayMonth();
		this.day=umService.getTodayDay();
		this.stryear=umService.getStryear();
		this.strmonth=umService.getStrmonth();
		
		umYear.setText(umService.getStryear());

		umMonth.setText(umService.getStrmonth());

		umIDLabel.setText(umService.getId());

		umNameLabel.setText(umService.getName());
		umNameLabel2.setText(umService.getName());
		umService.getId();

		umLastday.setText(umService.getLastDay());
		umPtLabel.setText(umService.getPTCount());
		buildPastCalendar();
		
		umService.bookedPtDate(stryear,strmonth);
		
	}

	//oper참조값 불러오기
	public void setOpener(Opener opener) {
		this.opener = opener;
	}
	public void umLogoutButtonProc() {
		//로그아웃 하시겠습니까
		//welcome화면으로 가기
	}
	//PT예약일 보내주기
	public void setbook() {
		umYear.setText(Integer.toString(year));
		umMonth.setText(Integer.toString(month));
		buildPastCalendar();
		umService.bookedPtDate(Integer.toString(year),Integer.toString(month));
	}
	//달력  연월 과거이동
	public void umpreviousMonthProc() {
		if(month==1) {
			month=12;
			year--;
		}
		else month--;
		setbook();
	}
	//달력  연월 미래 이동
	public void umNextMonthProc() {
		if(month==12) {
			month=1;
			year++;
		}
		else month++;
		setbook();
	}
	//윤년 확인
	public boolean isLeapYear() {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			return true;
		else
			return false;
	}
	//요일
	public int calMonth1stDayWeek() {
		Calendar calendar = Calendar.getInstance();
        String YMD = year + "-" + month + "-01";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            calendar.setTime(formatter.parse(YMD));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int dayNum = calendar.get(Calendar.DAY_OF_WEEK);
        // 1(일) 2(월) 3(화) 4(수) 5(목) 6(금) 7(토)
        return dayNum;
	}
	public void buildPastCalendar(){
		// (연, 월을 입력받으면 그 연, 월의 달력을 출력.)
		// 1. 연, 월 결정 = 파라미터로 받아옴
		// 2. 월 가지고 최대일 결정 (2월이면 윤년 test, 윤년이면 최대일배열=dayDataLeapYear)
		int dayMax = 0;
		int[] dayData = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] dayDataLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		boolean leapTest = isLeapYear();
		if (month == 2 && leapTest == true) { //2월이고 윤년
			dayMax = dayDataLeapYear[month - 1];
		}
		if (month == 2 && leapTest == false) { //2월이지만 윤년X
			dayMax = dayData[month - 1];
		}
		if (month != 2) { // 2월 아님
			dayMax = dayData[month - 1];
		}
		// 3. 월의 1일의 요일 계산
		int dayWeek1 = calMonth1stDayWeek(); // 기준 월의 1일의 요일
		// 4. 달력 형태로 출력 - printCalendar
		printCalendar(year, month, dayMax, dayWeek1);
	}

	public void printCalendar(int year, int month, int dayMax, int dayWeek1) {
		// 월의 1일의 요일부터(dayWeek1) 1~최대일 출력.
		Label[] ptReserves = new Label[] {
				ptReserve01,ptReserve02,ptReserve03,ptReserve04,ptReserve05,
				ptReserve06,ptReserve07,ptReserve08,ptReserve09,ptReserve10,
				ptReserve11,ptReserve12,ptReserve13,ptReserve14,ptReserve15,
				ptReserve16,ptReserve17,ptReserve18,ptReserve19,ptReserve20,
				ptReserve21,ptReserve22,ptReserve23,ptReserve24,ptReserve25,
				ptReserve26,ptReserve27,ptReserve28,ptReserve29,ptReserve30,
				ptReserve31,ptReserve32,ptReserve33,ptReserve34,ptReserve35,
				ptReserve36,ptReserve37,ptReserve38,ptReserve39,ptReserve40,
				ptReserve41,ptReserve42};
		Label[] sDays = new Label[] {
				sDay1,sDay2,sDay3,sDay4,sDay5,sDay6,sDay7,sDay8,sDay9,sDay10,
				sDay11,sDay12,sDay13,sDay14,sDay15,sDay16,sDay17,sDay18,sDay19,sDay20,
				sDay21,sDay22,sDay23,sDay24,sDay25,sDay26,sDay27,sDay28,sDay29,sDay30,
				sDay31,sDay32,sDay33,sDay34,sDay35,sDay36,sDay37,sDay38,sDay39,sDay40,
				sDay41,sDay42};
		for (int i = 0; i < 42; i++) {
			sDays[i].setText(" ");
			ptReserves[i].setText(" ");
		}
		int j=0;
		for (j = 1; j < dayWeek1; j++) {
			System.out.println("j : "+sDays[j]);
			sDays[j].setText(" ");
			System.out.println("te"+sDays[j].getText());
		}
		for (int i = 1; i <= dayMax; i++) {
			sDays[j+i-2].setText(Integer.toString(i));
		}
		//예약된 PT 날자표시.
		ArrayList<Integer> Ptmon = umService.bookedPtDate(Integer.toString(year),Integer.toString(month));
		int indexBoPt;
		for(int i=0;i<Ptmon.size();i++) {
			indexBoPt=Ptmon.get(i)+dayWeek1;
			ptReserves[indexBoPt-2].setText("피티 예약중");
		}
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
	//운동기록전환
	public void umGoToRcProc() {
		opener.rcOpen();
	}
	//버튼 클릭으로 인바디로 전환
	public void umGoToInbobyProc() {
		opener.inbodySelectOpen();
	}
	
	
}
