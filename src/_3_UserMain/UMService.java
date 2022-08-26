package _3_UserMain;

public class UMService {
	private UMDAO umDao;
	private String userId;
	private String userName;
	//유저 메인 실행(이 메서ㅡ의 구현은 로그인 이밴트로
	public UMService(String userId,String userName) {
		umDao = new UMDAO();
		this.userId=userId;
		getId();//유저메인화면구현과 동시에  아이디표시
		getName();
	}
	
	//라벨에 아이디값 전송
	public String getId() {
		return userId;
	}
	//라벨에 이름 값 전송
	public String getName() {
		return userName;
	}
	//쿼리문으로 피티카운트 가져오기
	public String getPTCount() {
		String ptc = Integer.toString(umDao.PTCount(userId));
		return ptc;
	}
	//쿼리문으로 헬스이용마지막 날 가져오기
	public String getLastDay() {
		String lastday = umDao.lastday(userId);
		return lastday;
	}
	
}
