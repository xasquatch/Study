package ch06.constructor;

public class DefaultPerson {

	String name;
	int age;
	boolean isHungry;
	
	DefaultPerson(){}
	DefaultPerson(String n, int a, boolean is){
		name = n;
		age = a;
		isHungry = is;
	}

	@Override
	public String toString() {
		return name+age+isHungry;
	}
	public static void main(String[] args) {
		
		DefaultPerson ps = new DefaultPerson();
		ps.name = "ȫ";
		ps.age = 10;
		ps.isHungry = false;
		
		System.out.println(ps.toString());
		
		DefaultPerson ps1 = new DefaultPerson("d",77,true);
		System.out.println(ps1.toString());
	}

}
