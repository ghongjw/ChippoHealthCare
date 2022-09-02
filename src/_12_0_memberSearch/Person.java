package _12_0_memberSearch;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

	private StringProperty name;
	private StringProperty gender;
	private IntegerProperty age;
	private StringProperty mobile;
	private StringProperty branch;
	private StringProperty purpose;
	private StringProperty expiryDate;
	private IntegerProperty PTcount;

	public Person(SimpleStringProperty name, SimpleStringProperty gender, SimpleIntegerProperty age,
			SimpleStringProperty mobile, SimpleStringProperty branch, SimpleStringProperty purpose,
			SimpleStringProperty expiryDate, SimpleIntegerProperty PTcount) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.mobile = mobile;
		this.branch = branch;
		this.purpose = purpose;
		this.expiryDate = expiryDate;
		this.PTcount = PTcount;
	}

	public StringProperty getName() {
		return name;
	}

	public StringProperty getGender() {
		return gender;
	}

	public IntegerProperty getAge() {
		return age;
	}

	public StringProperty getMobile() {
		return mobile;
	}

	public StringProperty getBranch() {
		return branch;
	}

	public StringProperty getPurpose() {
		return purpose;
	}

	public StringProperty getExpiryDate() {
		return expiryDate;
	}

	public IntegerProperty getPTcount() {
		return PTcount;
	}

}
