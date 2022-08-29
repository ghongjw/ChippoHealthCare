package _4_perchase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PcService {
	private PcDTO pcDto = new PcDTO();
	private PcService PcService;
	private PcController pcController;
	private PcConfirmController pcConfirmController;
	private int todayYear, todayMonth,todayDay,monthFare,MonthTotalFare,expireYear,expireMonth,expireDay,PtCount;
	private int totalFarecal;
	
	//헬스장 개월수에 따른 이용료
	public String monthPareCal(int monthPare) {
		String pcUsePare;
		if(monthPare<3) {
			monthPare = monthPare*100000;
		}if(monthPare<6) {
			monthPare = monthPare*95000;
		}if(monthPare>=6) {
			monthPare=monthPare*90000;
		}
		pcUsePare = Integer.toString(monthPare);
	
		return pcUsePare;
	}

	public void setPTAndExpireDay() {

	}

	public void today() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String regDate = sdf.format(date);
		String[] DateSplit = regDate.split("-");
		String stryear = DateSplit[0];
		String strmonth = DateSplit[1];
		String strday = DateSplit[2];

		todayYear=Integer.parseInt(stryear);
		todayMonth=Integer.parseInt(strmonth);
		todayDay=Integer.parseInt(strday);
	}
	public void perchaced(String id,int monthFare, int ptFare) {
		PcDAO pcDao = new PcDAO();
		today();
		totalFarecal=pcController.getTotalFarecal();
		pcDao.getLastDay(id,pcDto);
		expireYear = pcDto.getExpire_year();
		expireMonth = pcDto.getExpire_month();
		expireDay = pcDto.getExpire_day();
		PtCount = ptFare+pcDto.getPtCount();
		
		if(expireDay==0)expireDay=todayDay;
		if(expireYear>todayYear) {
			calculate(expireMonth);
		}
		else if(expireYear==todayYear) {
			if(expireMonth>todayMonth) {
				calculate(expireMonth);
			}
			else if(expireMonth==todayMonth) {
				if(expireDay>=todayDay) {calculate(expireMonth);}
				else if (expireDay<todayDay) {
					expireYear=todayYear;
					calculate(todayMonth);
				}
			}else if(expireMonth < todayMonth) {
				expireYear=todayYear;
				calculate(todayMonth);
			}
		}
		else if (expireYear<todayYear) {
			expireYear=todayYear;
			calculate(todayMonth);
		}
		
		pcDao.setLastDay(id,expireYear,expireMonth,expireDay,PtCount);
		System.out.println("id : "+id+","+expireYear+","+expireMonth+expireDay+PtCount);
		System.out.println("id : "+id+","+todayYear+","+todayMonth+todayDay+PtCount);
	}

	public void calculate(int ex) {
		monthFare=pcController.getMonthFare();
		expireMonth=ex+monthFare;
		System.out.println("mon :"+monthFare);
		if(expireMonth>12) {
			expireYear++;
			expireMonth = expireMonth-12;
		}
	}
	public PcDTO getPcDTO() {
		return pcDto;
	}
	public void setPcController(PcController pcController) {
		this.pcController=pcController;
	}
}
