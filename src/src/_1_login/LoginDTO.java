package _1_login;

public class LoginDTO {
	 private String id; 
	 private String pw; 
	 private String login;
	 private String name;
	 private String expireYear;
	 private String expireMonth;
	 private String expireDay;
	 private String ptcount;
	
	 
	 public String getExpireYear() {
		return expireYear;
	}
	public void setExpireYear(String expireYear) {
		this.expireYear = expireYear;
	}
	public String getExpireMonth() {
		return expireMonth;
	}
	public void setExpireMonth(String expireMonth) {
		this.expireMonth = expireMonth;
	}
	public String getExpireDay() {
		return expireDay;
	}
	public void setExpireDay(String expireDay) {
		this.expireDay = expireDay;
	}
	public String getPtcount() {
		return ptcount;
	}
	public void setPtcount(String ptcount) {
		this.ptcount = ptcount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}


	
}
