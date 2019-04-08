package chapter6;

public class PersonTest {

	public static void main(String[] args) {
		Person ps1 = new Person();
		ps1.name = "정준";
		ps1.isHungry = true;
		System.out.println(ps1.name+":"+ps1.isHungry);
		ps1.eat();
		System.out.println(ps1.name + ":" + ps1.isHungry);
		
		Person ps2 = new Person();
		ps2.name = "정조준";
		ps2.isHungry = true;
		System.out.println(ps2.name+":"+ps2.isHungry);
		ps2.eat();
		System.out.println(ps2.name + ":" + ps2.isHungry);
		
		
	}
	
	
	
	
}
