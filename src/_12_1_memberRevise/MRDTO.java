package _12_1_memberRevise;

public class MRDTO {
	private String name;
	private String gender;
	private String age;
	private String phone;
	private String branch;
	private String com;
	private String diet;
	private String heal;
	private String purpose;

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public String getHeal() {
		return heal;
	}

	public void setHeal(String heal) {
		this.heal = heal;
	}

	private String days;
	private int pt;

	private String[] expiryDate;
	private int expire_year;
	private int expire_month;
	private int expire_day;

	private String oldName;

	public String[] getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String[] expiryDate) {
		this.expiryDate = expiryDate;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public int getPt() {
		return pt;
	}

	public void setPt(int pt) {
		this.pt = pt;
	}

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

}
