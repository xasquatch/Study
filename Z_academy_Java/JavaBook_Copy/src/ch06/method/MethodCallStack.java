package ch06.method;

public class MethodCallStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodCallStack mcs = new MethodCallStack();
		mcs.aMethod();
	}
	
	public void aMethod() {
		System.out.println("aMethod start");
		int age = 10;
		bMethod(age);
		System.out.println("aMethod end");
		
	}
	
	public void bMethod(int age) {
		System.out.println("bMethod start");
		System.out.println(age);
		System.out.println("bMethod end");
	}
}
