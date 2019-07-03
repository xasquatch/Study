package com.test.di4;

import java.util.ArrayList;

public class Player {//야구 선수 클래스
	
	private String name; //이름
	private int age; //나이
	private ArrayList<String> position;//포지션
	private double height;//키
	private double weight;//몸무게
	
	//기본 생성자
	public Player() { }

	//이름, 나이, 포지션 값을 전달받아 변수를 초기화시킬 생성자
	public Player(String name, int age, ArrayList<String> position) {
		this.name = name;
		this.age = age;
		this.position = position;
	}
	
	//getter,setter메소드 
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



