package com.test.di2;

//����� ���� ������ ������ִ� Ŭ���� 
public class PersonInfo {// PersonInfoŬ���� -> personŬ������ ������.
	
	//Person��ü�� ������ �������� ����
	private Person person; //��ü�� ���� �ؾ��� -_-
	
	//�����ڸ� ���� Person��ü�� ���� ������ ���� �ؾ� �ϹǷ�..
	//������ �ϳ� �����
	public PersonInfo(Person person) {
		this.person = person;
	}
	//�⺻������ : �ƹ��ϵ� ���� ����
	public PersonInfo() {}

	//Person��ü�� ���� ������ ������ִ� �޼ҵ�
	public void getPersonInfo() {
		//���� : Person��ü�� ���� ���������� ����Ǿ� ������?
		if(person != null) {
			System.out.println("�̸� : " + person.getName());
			System.out.println("���� : " + person.getGender());
			System.out.println("���� : " + person.getAge());
			System.out.println("�ֹι�ȣ : " + person.getIdNo());
			System.out.println("-----------------------------");
		}
	}
	//Person��ü�� �Ű������� ���޹޾�.. ���� person������ ������ �޼ҵ� 
	public void setPerson(Person person) {
		this.person = person;
	}
	
}




