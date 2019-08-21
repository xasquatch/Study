package ch10.lambda.functional;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToIntFunction;


public class FunctionTest {
	private Person person;

	public void addPerson(BiFunction<String, Integer, Person> function, String name, Integer age) {
		person = function.apply(name, age);
		person.name = "È«±æµ¿";
		person.age = 2455;
	}

	public void printPerson(Function<String, String> function, String name) {
		System.out.println(function.apply(name));
	}

	public void printAge(ToIntFunction<String> function, String name) {
		System.out.println(name + "ÀÇ ³ªÀÌ" + function.applyAsInt(name));
	}

	public static void main(String[] args) {
		FunctionTest ft = new FunctionTest();
		ft.addPerson((name, age)->{
			return new Person(name, age);
		},"È«±æµ¿",10);

		ft.printPerson((name)->{
			if (ft.person.name.equals(name)) {
				return ft.person.toString();
			}else {
				return "unknown user";
			}
		}, "È«±æµ¿");
		
		ft.printAge((name)->{
			if (ft.person.name.equals(name)) {
				return ft.person.age;
			}else {
				return 0;
			}
		}, "È«±æµ¿");
		
	}

}

class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}