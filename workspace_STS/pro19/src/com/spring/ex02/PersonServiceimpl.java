package com.spring.ex02;

public class PersonServiceimpl implements PersonService {

	private String name;
	private int age;

	public PersonServiceimpl() {
	}

	public PersonServiceimpl(String name) {
		super();
		this.name = name;
	}

	public PersonServiceimpl(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public void sayhello() {
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + age + "��");
	}

}
