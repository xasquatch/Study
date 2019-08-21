package ch07.extend;

class Parent{
	String x = "parent";
}

class Child extends Parent{
	String x = "child";
	
	void method() {
		String x = "method";
		System.out.println(x);
		System.out.println(this.x);
		System.out.println(super.x);
	}
}
public class ScopeTest {

	public static void main(String[] args) {
		Child ch = new Child();
		ch.method();

	}
	

}
