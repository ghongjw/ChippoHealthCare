package _3_UserMain;

public class UMDTO {
	private String id, name, workoutday,start_time,end_time,ptbooked;
	private int expire_year,expire_month,expire_day;
	public int getExpire_year() {
		return expire_year;
	}
	public void setExpire_year(int expire_year) {
		this.expire_year = expire_year;
	}
	public int getExpire_month() {
		return expire_month;
	}
	public void setExpire_month(int expire_month) {
		this.expire_month = expire_month;
	}
	public int getExpire_day() {
		return expire_day;
	}
	public void setExpire_day(int expire_day) {
		this.expire_day = expire_day;
	}
	private int ptnum;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getWorkoutday() {
		return workoutday;
	}
	public void setWorkoutday(String workoutday) {
		this.workoutday = workoutday;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getPtbooked() {
		return ptbooked;
	}
	public void setPtbooked(String ptbooked) {
		this.ptbooked = ptbooked;
	}
	public int getPtnum() {
		return ptnum;
	}
	public void setPtnum(int ptnum) {
		this.ptnum = ptnum;
	}
	
}
