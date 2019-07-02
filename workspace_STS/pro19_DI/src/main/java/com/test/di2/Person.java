package com.test.di2;

public class Person{
	private String name, gender, age, inNo;

	public Person() {}
	public Person(String name, String gender, String age, String inNo) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.inNo = inNo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setInNo(String inNo) {
		this.inNo = inNo;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public String getAge() {
		return age;
	}
	public String getInNo() {
		return inNo;
	}
	
}
