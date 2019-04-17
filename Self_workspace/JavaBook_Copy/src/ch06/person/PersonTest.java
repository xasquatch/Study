package ch06.person;

public class PersonTest {

	public static void main(String[] args) {

		Person ps = new Person();
		ps.name = "È«±æµ¿";
		ps.isHungry = true;
		System.out.println(ps.name+" "+ps.isHungry);
		ps.eat();
		System.out.println(ps.name+" "+ps.isHungry);
		
		Person ps2 = new Person();
		ps2.name = "°ïÀß·¹½º";
		ps2.isHungry = true;
		System.out.println(ps2.name+" "+ps2.isHungry);
		System.out.println(ps.name+" "+ps.isHungry);
		
	}

}
