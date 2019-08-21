package ch08.inter.method;

interface DefaultMethodInterface{
	void abstractMethod();
	
	default void defaultMethod() {
		System.out.println("basic method");
	}
}
public class DefaultMethodTest implements DefaultMethodInterface{

	@Override
	public void abstractMethod() {
		System.out.println("오버라이딩 메소드");
	}
	
	public static void main(String[] args) {
		DefaultMethodInterface d = new DefaultMethodTest();
		d.abstractMethod();
		d.defaultMethod();
		
	}

}
