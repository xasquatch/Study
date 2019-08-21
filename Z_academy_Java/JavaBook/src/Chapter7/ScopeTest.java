package Chapter7;

class Parent {
	String x = "Parent";

	void method() {
		String x = "method";
		System.out.println("ÀÚ¹Ù" + x + this.x);
	}
}

class Child extends Parent {
	String x = "Child";

	void method() {
		String x = "method";
		System.out.println("x : " + x);
		System.out.println("this.x : " + this.x);
		System.out.println("super.x : " + super.x);
	}

}

public class ScopeTest {

	public static void main(String[] args) {
		Child child = new Child();
		Parent parent = new Parent();
		child.method();
		parent.method();
	}

}
