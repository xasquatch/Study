package com.test.di2;

public class Person {
	private String name;//����̸�
	private String gender;//����
	private String age;//����
	private String idNo;//�ֹι�ȣ
	
	//�⺻ ������ : �� ����
	public Person() {}
	
	//���� ������ : ��ü ������ �����ڰ� ȣ��ɋ�.. 
	//�̸�,����,����,�ֹι�ȣ�� ���� �޾� �ʱ�ȭ
	public Person(String name, String gender, String age, String idNo) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.idNo = idNo;
	}
	
	//getter,setter�޼ҵ� 
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
