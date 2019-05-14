package ch10.lambda.ref;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class ConstructorReference {

	public static void main(String[] args) {
		Consumer<StringBuffer> cons = (src)->{
			System.out.println(src.capacity()+":"+src.length());
		};

		Supplier<StringBuffer> s1 = StringBuffer::new;
		StringBuffer sb1 = s1.get();
		cons.accept(sb1);
		
		Function<String, StringBuffer> f1 = StringBuffer::new;
		StringBuffer sb2 = f1.apply("Hello");
		cons.accept(sb2);
		
		IntFunction<StringBuffer> f2 = StringBuffer::new;
		StringBuffer sb3 = f2.apply(10);
		cons.accept(sb3);
	}

}
