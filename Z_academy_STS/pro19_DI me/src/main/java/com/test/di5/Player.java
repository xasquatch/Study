package com.test.di5;

import java.util.ArrayList;

public class Player {

	private String name;
	private int age, height, weight;
	private ArrayList<String> Position;

	Player() {
	}

	public Player(String name, int age, int height, int weight, ArrayList<String> Position) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.Position = Position;
	}

	public Player(String name, int age, ArrayList<String> Position) {
		super();
		this.name = name;
		this.age = age;
		this.Position = Position;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

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
		return Position;
	}

	public void setPosition(ArrayList<String> Position) {
		this.Position = Position;
	}

}
