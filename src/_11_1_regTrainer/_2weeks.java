package _11_1_regTrainer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class _2weeks {
	
	// 오늘부터 2주 날짜 리스트에 담아서 반환하는 메서드
	public ArrayList get2weeks() {
		ArrayList weeks2 = new ArrayList<>();
		int[] days = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
		for (int i = 0; i < days.length; i++) {
			Calendar cal = Calendar.getInstance();
			String format = "yyyy-MM-dd";
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			cal.add(cal.DATE, +days[i]); // 날짜를 하루 뺀다.
			String date = sdf.format(cal.getTime());
			weeks2.add(date);
		}
		return weeks2;
	}

}
