package com.test.di2;

public class Person {
	private String name;//사람이름
	private String gender;//성별
	private String age;//나이
	private String idNo;//주민번호
	
	//기본 생성자 : 일 안함
	public Person() {}
	
	//인자 생성자 : 객체 생성시 생성자가 호출될떄.. 
	//이름,성별,나이,주민번호를 전달 받아 초기화
	public Person(String name, String gender, String age, String idNo) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.idNo = idNo;
	}
	
	//getter,setter메소드 
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}


	

	
}
