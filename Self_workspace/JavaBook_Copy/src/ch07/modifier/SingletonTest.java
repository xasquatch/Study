package ch07.modifier;

class SingletonClass{
	private static SingletonClass instance = new SingletonClass();
	private SingletonClass() {}
	
	public static SingletonClass getInstance() {
		return instance;
	}
	
	
	
	public static void setInstance(SingletonClass instance) {
		SingletonClass.instance = instance;
	}

	public void sayHello() {
		System.out.println("Hello");
	}
	
}
public class SingletonTest {

	public static void main(String[] args) {
		
//		SingletonClass sc3 = new SingletonClass();
		
		
		
		SingletonClass sc1 = SingletonClass.getInstance();
		SingletonClass sc2 = SingletonClass.getInstance();
		
		System.out.printf("두 객체는 같은가? %b%n",sc1 == sc2);
		sc1.sayHello();
	}

}
