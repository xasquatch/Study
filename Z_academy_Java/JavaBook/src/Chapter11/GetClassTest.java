package Chapter11;

import java.lang.reflect.InvocationTargetException;

public class GetClassTest {

	public void sayHello() {
		System.out.println("hello");
	}
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		GetClassTest gct = new GetClassTest();
		Class gctClass = gct.getClass();
		System.out.println(gctClass.getName());
		System.out.println(gctClass.getDeclaredMethods().length);
		
		Class getClass2 = GetClassTest.class;
		gctClass.getDeclaredMethod("sayHello").invoke(gct);
	}
}
