package Chapter7;

public class Person {
	String name;
	int age;
	
	Person (){}
	Person (String name, int age){
		this.name = name;
		this.age = age;
	}	
	
	public void eat() {
		System.out.println("¹ä¸Ô±â");
	}

	public void jump() {
		System.out.println("¶Ù±â");
	}
}