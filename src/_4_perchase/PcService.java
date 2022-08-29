package _4_perchase;

public class PcService {

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
}
