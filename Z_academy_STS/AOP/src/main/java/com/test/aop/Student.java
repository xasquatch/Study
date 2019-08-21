package com.test.aop;

public class Student {

	private String name, age, hakbun, grade;

	public Student() {
	}

	public Student(String name, String age, String hakbun, String grade) {
		super();
		this.name = name;
		this.age = age;
		this.hakbun = hakbun;
		this.grade = grade;
	}

	public void getinfo() {
		System.out.println("이름 : " + getName());
		System.out.println("나이 : " + getAge());
		System.out.println("학번 : " + getHakbun());
		System.out.println("학년 : " + getGrade());
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

	public String getHakbun() {
		return hakbun;
	}

	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
