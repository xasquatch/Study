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
		System.out.println("�̸� : " + getName());
		System.out.println("���� : " + getAge());
		System.out.println("�й� : " + getHakbun());
		System.out.println("�г� : " + getGrade());
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
