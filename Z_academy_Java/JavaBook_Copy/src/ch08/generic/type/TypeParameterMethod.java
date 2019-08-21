package ch08.generic.type;

public class TypeParameterMethod<T> {

	T some;
	
	
	
	public TypeParameterMethod(T some) {
		this.some = some;
	}

	public <P> void method1(P p) {
		System.out.println("클래스 레벨의 T "+some.getClass().getName());
		System.out.println("파라미터  T "+p.getClass().getName());
	}

	public <P> P method2(P p) {
		System.out.println("클래스 레벨의 T "+some.getClass().getName());
		System.out.println("파라미터  T "+p.getClass().getName());
		return p;
	}
	
	
	public static void main(String[] args) {
		TypeParameterMethod<String> tpmt = new TypeParameterMethod("Hello");
		tpmt.method1(10);
		tpmt.<Long>method2(20L);

		int i = StaticMethodTest.method1(20);
		System.out.println(i);
		StaticMethodTest.method2(20L);
		
	}

}

class StaticMethodTest<T>{
	public static <P> P method1(P p){
		System.out.println("do someThing!");
		return p;
	}
	public static <P> void method2(P p){
		System.out.println("do someThing!");
		
	}
}

