package ch08.inter.method;

interface StaticMethodInterface{
	static void staticMethod(){
		System.out.println("static method");
	}
}

public class StaticMethod {

	public static void main(String[] args) {
		
		StaticMethodInterface.staticMethod();
		
	}

}
