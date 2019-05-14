package ch10.lambda.ref;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReference3 {

	public static void main(String[] args) {
		
		String base = "Lambda";
		Function<String, Boolean> f = (str) -> base.equals(str);
		System.out.println(f.apply("Lambda"));
		
		Function<String, Boolean> f2 = base::equals;
		System.out.println(f2.apply("Lambda"));
		
		Consumer<String> c = System.out::println;
		c.accept("Lambda");
	}

}
