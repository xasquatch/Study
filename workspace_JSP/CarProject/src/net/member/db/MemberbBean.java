package net.member.db;

import java.sql.Timestamp;

public class MemberbBean {

	String id, pass, name,	email,	address, phone,	mobile;
	int age;	
	Timestamp date;
	
	public MemberbBean(){}
	public MemberbBean(String id, String pass, String name, String email, String address, String phone, String mobile,
			int age, Timestamp date) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.mobile = mobile;
		this.age = age;
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}	
	
	
	
	
	
	
}
