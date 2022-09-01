package _3_UserMain;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

import _0_main.Opener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

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
	@FXML private VBox dBox01,dBox02,dBox03,dBox04,dBox05,dBox06,dBox07,dBox08,dBox09,dBox10;
	@FXML private VBox dBox11,dBox12,dBox13,dBox14,dBox15,dBox16,dBox17,dBox18,dBox19,dBox20;
	@FXML private VBox dBox21,dBox22,dBox23,dBox24,dBox25,dBox26,dBox27,dBox28,dBox29,dBox30;
	@FXML private VBox dBox31,dBox32,dBox33,dBox34,dBox35,dBox36,dBox37,dBox38,dBox39,dBox40;
	@FXML private VBox dBox41,dBox42;

	//서비스불러오기
	private UMService umService;

	private UMDTO umDto;
	//창 불러오기
	private Opener opener;
	private String userId;
	private String userName;
	
	ArrayList<Label> sdays = new ArrayList<Label>();
	Label todayLabel;

	private int year,month,day,todayYear,todayMonth,todayDay,emptydate;
	private String stryear,strmonth,strday;

	private String cYear,cMonth,cDay,clickdDate;
	private Label[] sDays;
	private VBox[] vboxs = new VBox[42];
	
	public void setOpenerinfo(Opener opener,String id,String name) {
		this.setOpener(opener);
		umIDLabel.setText(id);
		umNameLabel.setText(name);
		umNameLabel2.setText(name);

		this.opener = opener;
		this.userId =id;
		this.userName =name;
		this.setNodes();
		System.out.println(this.opener);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//setOpener();
		umService=new UMService();
		
	}
	public void setNodes() {
		umService.setId(userId, userName);
		umService.today();
		todayLabel = new Label();
		
		this.year=umService.getTodayYear();
		this.month=umService.getTodayMonth();
		this.day=umService.getTodayDay();
		this.stryear=umService.getStryear();
		this.strmonth=umService.getStrmonth();
		this.strday=umService.getStrday();

		umYear.setText(umService.getStryear());
		umMonth.setText(umService.getStrmonth());

		
		umService.getId();

		umLastday.setText(umService.getLastDay());
		umPtLabel.setText(umService.getPTCount());
		buildPastCalendar();

		umService.bookedPtDate(stryear,strmonth);
		todayselct(emptydate);
	}

	//oper참조값 불러오기
	
	public void umLogoutButtonProc() {
		opener.logoutPg();
		//로그아웃 하시겠습니까
		//welcome화면으로 가기
	}
	public void backButtonProc() {
		opener.logoutPg();
	}
	
	public UMService getUmService() {
		return umService;
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
		sDays = new Label[] {
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
			sDays[j].setText(" ");
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
		emptydate=j;
		setTodaylable();
	}
	//버튼 클릭으로 회원정보 수정 페이지로 전환
	public void umgoToUiButtonProc() {
		opener.userInfoUpdateConfirmPwOpen();

	}
	//버튼 클릭으로 이용권 구매페이지로 전환
	public void umGoTOPerchaseProc() {
		opener.PcOpen();
		System.out.println(opener);
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

	public String getuserId() {
		return userId;
	}

	public String getuserName() {
		return userName;
	}
	public void clickCalender(Label label) {
		cYear=umYear.getText();
		cMonth=umMonth.getText();
		if(cMonth.length()==1) {
			cMonth = "-0"+cMonth;
		}
		cDay=label.getText();

		if(cDay.equals(" ")==false) {
			opener.userPTUpdateOpen();
		}
		clickdDate = cYear+"-"+cMonth+"-"+cDay;
	}
	public String clikedDateMehod() {
		return clickdDate;
	}
	public void todayselct(int a) {
		int tmp = day + a - 2;
		VBox[] vboxs = {dBox01,dBox02,dBox03,dBox04,dBox05,dBox06,dBox07,dBox08,dBox09,dBox10,
				dBox11,dBox12,dBox13,dBox14,dBox15,dBox16,dBox17,dBox18,dBox19,dBox20,
				dBox21,dBox22,dBox23,dBox24,dBox25,dBox26,dBox27,dBox28,dBox29,dBox30,
				dBox31,dBox32,dBox33,dBox34,dBox35,dBox36,dBox37,dBox38,dBox39,dBox40,
				dBox41,dBox42
		};
		String tmpMonth= umMonth.getText();
		if(tmpMonth.length()==1)
			tmpMonth="0"+tmpMonth;
		vboxs[tmp].getChildren().add(todayLabel);
		
		if(umYear.getText().equals(stryear)&&tmpMonth.equals(strmonth)) {
			todayLabel.setText("TODAY!!");
		}else if(tmpMonth.equals(strmonth)==false){
		
		}
	}
	public void setTodaylable() {
		String tmpMonth= umMonth.getText();
		if(tmpMonth.length()==1)
			tmpMonth="0"+tmpMonth;
		if(umYear.getText().equals(stryear)&&tmpMonth.equals(strmonth)) {
			todayLabel.setText("TODAY!!");
		}else if(tmpMonth.equals(strmonth)==false){
			todayLabel.setText("");
		}
	}
	public Opener setOpener(Opener opener) {
		this.opener=opener;
		return opener;
	}

	//캘린더 클릭시 그에 맞는 날자의 
	public void vboxclicked01() {
		clickCalender(sDay1);
	}
	public void vboxclicked02() {
		clickCalender(sDay2);
	}
	public void vboxclicked03() {
		clickCalender(sDay3);
	}
	public void vboxclicked04() {
		clickCalender(sDay4);
	}
	public void vboxclicked05() {
		clickCalender(sDay5);
	}
	public void vboxclicked06() {
		clickCalender(sDay6);
	}
	public void vboxclicked07() {
		clickCalender(sDay7);
	}
	public void vboxclicked08() {
		clickCalender(sDay8);
	}
	public void vboxclicked09() {
		clickCalender(sDay9);
	}
	public void vboxclicked10() {
		clickCalender(sDay10);
	}
	public void vboxclicked11() {
		clickCalender(sDay11);
	}
	public void vboxclicked12() {
		clickCalender(sDay12);
	}
	public void vboxclicked13() {
		clickCalender(sDay13);
	}
	public void vboxclicked14() {
		clickCalender(sDay14);
	}
	public void vboxclicked15() {
		clickCalender(sDay15);
	}
	public void vboxclicked16() {
		clickCalender(sDay16);
	}
	public void vboxclicked17() {
		clickCalender(sDay17);
	}
	public void vboxclicked18() {
		clickCalender(sDay18);
	}
	public void vboxclicked19() {
		clickCalender(sDay19);
	}
	public void vboxclicked20() {
		clickCalender(sDay20);
	}
	public void vboxclicked21() {
		clickCalender(sDay21);
	}
	public void vboxclicked22() {
		clickCalender(sDay22);
	}
	public void vboxclicked23() {
		clickCalender(sDay23);
	}
	public void vboxclicked24() {
		clickCalender(sDay24);
	}
	public void vboxclicked25() {
		clickCalender(sDay25);
	}
	public void vboxclicked26() {
		clickCalender(sDay26);
	}
	public void vboxclicked27() {
		clickCalender(sDay27);
	}
	public void vboxclicked28() {
		clickCalender(sDay28);
	}
	public void vboxclicked29() {
		clickCalender(sDay29);
	}
	public void vboxclicked30() {
		clickCalender(sDay30);
	}
	public void vboxclicked31() {
		clickCalender(sDay31);
	}
	public void vboxclicked32() {
		clickCalender(sDay32);
	}
	public void vboxclicked33() {
		clickCalender(sDay33);
	}
	public void vboxclicked34() {
		clickCalender(sDay34);
	}
	public void vboxclicked35() {
		clickCalender(sDay35);
	}
	public void vboxclicked36() {
		clickCalender(sDay36);
	}
	public void vboxclicked37() {
		clickCalender(sDay37);
	}
	public void vboxclicked38() {
		clickCalender(sDay38);
	}
	public void vboxclicked39() {
		clickCalender(sDay39);
	}
	public void vboxclicked40() {
		clickCalender(sDay40);
	}
	public void vboxclicked41() {
		clickCalender(sDay41);
	}
	public void vboxclicked42() {
		clickCalender(sDay42);
	}

}