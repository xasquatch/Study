package ch08.generic.type;

class Person{}
class SpiderMan extends Person{}
class PersonBox<T>{}

public class WildTypeTest {

	public void method1(PersonBox some) {}
	public void method2(PersonBox<? extends Person> some) {}
	public void method3(PersonBox<? super Person> some) {}
	
	public static void main(String[] args) {
		WildTypeTest wtt = new WildTypeTest();
		
		wtt.method1(new PersonBox<Object>());
		wtt.method1(new PersonBox<Person>());
		wtt.method1(new PersonBox<SpiderMan>());
		
//		wtt.method2(new PersonBox<Object>());
		wtt.method2(new PersonBox<Person>());
		wtt.method2(new PersonBox<SpiderMan>());
		
		wtt.method3(new PersonBox<Object>());
		wtt.method3(new PersonBox<Person>());
//		wtt.method3(new PersonBox<SpiderMan>());
		
	}

}
