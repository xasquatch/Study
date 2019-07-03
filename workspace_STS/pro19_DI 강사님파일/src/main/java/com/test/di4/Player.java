package com.test.di4;

import java.util.ArrayList;

public class Player {//�߱� ���� Ŭ����
	
	private String name; //�̸�
	private int age; //����
	private ArrayList<String> position;//������
	private double height;//Ű
	private double weight;//������
	
	//�⺻ ������
	public Player() { }

	//�̸�, ����, ������ ���� ���޹޾� ������ �ʱ�ȭ��ų ������
	public Player(String name, int age, ArrayList<String> position) {
		this.name = name;
		this.age = age;
		this.position = position;
	}
	
	//getter,setter�޼ҵ� 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<String> getPosition() {
		return position;
	}

	public void setPosition(ArrayList<String> position) {
		this.position = position;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}



