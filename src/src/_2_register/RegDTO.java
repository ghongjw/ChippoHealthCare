package _2_register;

import _1_login.LoginDTO;

public class RegDTO extends LoginDTO {
	private String name;
	private String gender;
	private String address;
	private String email;
	private String branch;
	private String mobile;
	private String age;
	private String ptcount;
	private int num;
	private int expireyear;
	private int expiremonth;
	private int expireday;
	private String purpose;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPtcount() {
		return ptcount;
	}

	public void setPtcount(String ptcount) {
		this.ptcount = ptcount;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getExpireyear() {
		return expireyear;
	}

	public void setExpireyear(int expireyear) {
		this.expireyear = expireyear;
	}

	public int getExpiremonth() {
		return expiremonth;
	}

	public void setExpiremonth(int expiremonth) {
		this.expiremonth = expiremonth;
	}

	public int getExpireday() {
		return expireday;
	}

	public void setExpireday(int expireday) {
		this.expireday = expireday;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

}