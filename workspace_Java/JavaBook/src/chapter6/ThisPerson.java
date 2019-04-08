package chapter6;

public class ThisPerson {
	String name;
	int age;
	boolean isHungry;
	
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isHungry() {
		return isHungry;
	}
	public void setHungry(boolean isHungry) {
		this.isHungry = isHungry;
	}
	
//	String getPersonInfo() {
//		return String.format("name : %s, age : %d, isHungry : %b", this.name, this.age, this.isHungry);
//	}

//	public ThisPerson(String name, int age, boolean isHungry) {
////	super();
//	this.name = name;
//	this.age = age;
//	this.isHungry = isHungry;
//	}

	public static void main(String[] args) {

//		ThisPerson person = new ThisPerson("ȫ�浿",20,true);
////		person.setName = "ȫ�浿";
//				
//		System.out.println(person.getPersonInfo());
	}

}
