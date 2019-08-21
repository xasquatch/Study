package com.test.aop;

public class Staff {

	private String name, dept;
	private int age;

	public void getinfo() {
		System.out.println("이름 : " + getName());
		System.out.println("나이 : " + getAge());
		System.out.println("부서명 : " + getDept());

	}

	public Staff() {
	}

	public Staff(String name, String dept, int age) {
		super();
		this.name = name;
		this.dept = dept;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
