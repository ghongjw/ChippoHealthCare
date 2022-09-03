package _11_1_regTrainer;

//NUM                                                NUMBER
//NAME                                               VARCHAR2(20)
//GENDER                                             VARCHAR2(5)
//AGE                                                VARCHAR2(10)
//SPEC                                               VARCHAR2(100)
//POINT                                              VARCHAR2(30)

public class RTDTO {
	// DB table 순서
	// num, name, gender, age, spec, point
	private int Num;
	private String name;
	private String age;
	private String spec;
	private String gender;
	private String point;

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

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getNum() {
		return Num;
	}

	public void setNum(int num) {
		Num = num;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

}
