package member;

import java.sql.Timestamp;

public class MemberBean {
	
	private String id; 
	private String passwd; 
	private String name; 
	private Timestamp reg_date; 
	private int age; 
	private String gender; 
	private String email;
	private String address; 
	private String tel;
	private String mtel;

	public MemberBean(){}
	
	public MemberBean(String id, String passwd, String name, Timestamp reg_date, int age, String gender, String email,
			String address, String tel, String mtel) {
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.reg_date = reg_date;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.tel = tel;
		this.mtel = mtel;
	}
	
	public String getId() {
		return id;
	}
	public String getPasswd() {
		return passwd;
	}
	public String getName() {
		return name;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
	public String getTel() {
		return tel;
	}
	public String getMtel() {
		return mtel;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	
	
	
}

