package ch11.string;

public class ImmutaleClass {

	public static void main(String[] args) {
		String a = "a";
		System.out.println(System.identityHashCode(a));
		System.out.println(a.hashCode());
		a = a+"b";
		System.out.println(System.identityHashCode(a));
		System.out.println(a.hashCode());
		System.out.println(a);
		
	}

}
