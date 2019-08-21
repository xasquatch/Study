package ch08.annotation;

import java.util.Date;

class SuperClass{
	protected void someMethod() {}
}

class SomeClass{
	@Deprecated
	public void oldMethod() {}
}

class DeprecatedTest{
	
	private void testdeprecated() {
		SomeClass sc = new SomeClass();
		sc.oldMethod();
		
		Date date = new Date(2019,1,1);
		
	}
	
	
}

class SuppressWarningTest{
	public static void method1() {
		@SuppressWarnings("unused")
		int i = 0;
	}
}
public class Test{

	public static void main(String[] args) {
	
	SuppressWarningTest.method1();
	
	
	}
}
