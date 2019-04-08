package chapter6;

public class OverloadConstructorPerson {
	String name = "�ƹ���";
	int age = 0;
	boolean isHungry = false;
		
	OverloadConstructorPerson(String name, int age, boolean isHungry) {
		this.name = name;
		this.age = age;
		this.isHungry = isHungry;
	}
	OverloadConstructorPerson(String name, int age) {
		this(name, age, false);
	}
	OverloadConstructorPerson(String name) {
		this(name, 0, false);
	}
	OverloadConstructorPerson() {
		this("ȫ�浿", 100, false);
	}

	public static void main(String[] args) {
		OverloadConstructorPerson p1 = new OverloadConstructorPerson();
		OverloadConstructorPerson p2 = new OverloadConstructorPerson("��");

		System.out.println(p1.isHungry);
		System.out.println(p2.name);
	}

}
