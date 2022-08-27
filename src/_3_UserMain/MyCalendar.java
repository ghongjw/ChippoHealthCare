//package _3_UserMain;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//
//import javafx.scene.control.Label;
//
//public class MyCalendar {
//	private UMController umController;
//	int year;
//	int month;
//	public void setYM(int year, int month) {
//		this.year = year;
//		this.month=month;
//	}
//	public boolean isLeapYear(int year) {
//		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
//			return true;
//		else
//			return false;
//	}
//
//	public int calMonth1stDayWeek(int year, int month) {
//		Calendar calendar = Calendar.getInstance();
//		String YMD = year + "-" + month + "-01";
//
//		int dayNum = calendar.get(Calendar.DAY_OF_WEEK);
//		// 1(일) 2(월) 3(화) 4(수) 5(목) 6(금) 7(토)
//		return dayNum;
//	}
//
//	public void buildPastCalendar(){
//		// (연, 월을 입력받으면 그 연, 월의 달력을 출력.)
//		// 1. 연, 월 결정 = 파라미터로 받아옴
//		// 2. 월 가지고 최대일 결정 (2월이면 윤년 test, 윤년이면 최대일배열=dayDataLeapYear)
//		int dayMax = 0;
//		int[] dayData = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//		int[] dayDataLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//		boolean leapTest = isLeapYear(year);
//		if (month == 2 && leapTest == true) { //2월이고 윤년
//			dayMax = dayDataLeapYear[month - 1];
//		}
//		if (month == 2 && leapTest == false) { //2월이지만 윤년X
//			dayMax = dayData[month - 1];
//		}
//		if (month != 2) { // 2월 아님
//			dayMax = dayData[month - 1];
//		}
//		// 3. 월의 1일의 요일 계산
//		int dayWeek1 = calMonth1stDayWeek(year, month); // 기준 월의 1일의 요일
//		// 4. 달력 형태로 출력 - printCalendar
//		printCalendar(year, month, dayMax, dayWeek1);
//	}
//
//	public void printCalendar(int year, int month, int dayMax, int dayWeek1) {
//		// 월의 1일의 요일부터(dayWeek1) 1~최대일 출력.
//		Label[] days =umController.getsDays();
//		int j=1;
//		for (j = 1; j < dayWeek1; j++) {
//			days[j].setText(Integer.toString(j));
//
//		}
//		for (int i = j+1; i <= dayMax; i++) {
//			days[i].setText(Integer.toString(i));
//		}
//	}
//
//}
//
//
