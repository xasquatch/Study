package chapter6;

public class Person {

	String name;
	int age;
	boolean isHungry;
	
	void eat() {
		System.out.println("�ȳ�");
		isHungry = false;
	}
	void work() {
		System.out.println("������");
		isHungry = true;
	}
	
}
