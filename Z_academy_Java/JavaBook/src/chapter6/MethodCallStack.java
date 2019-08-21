package chapter6;

public class MethodCallStack {
	public static void main(String[] args) {
		MethodCallStack mcs = new MethodCallStack();
		mcs.aMethod();
	}
	
	public void aMethod(){
		
		System.out.println("aMethod Start");
		int age = 10;
		bMethod(age);
		System.out.println("aMethod end");
	}
	
	public void bMethod(int age){
		
		System.out.println("bMethod start");
		System.out.printf("³ªÀÌ´Â : %d%n",age);
		System.out.println("bMethod end");
	}
}
