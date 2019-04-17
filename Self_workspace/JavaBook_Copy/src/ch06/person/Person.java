package ch06.person;

public class Person {

	String name;
	int age;
	boolean isHungry;

	void eat() {
		System.out.println("³È³È");
		isHungry = false;
	}

	void work() {
		System.out.println("¿­½ÉÈ÷");
		isHungry = true;
	}

}
