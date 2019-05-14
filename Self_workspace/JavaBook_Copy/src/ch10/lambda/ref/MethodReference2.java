package ch10.lambda.ref;

import java.util.Arrays;
import java.util.function.Function;

public class MethodReference2 {

	public static void main(String[] args) {
		Function<String, Integer> f1 = Integer::parseInt;
		System.out.println(f1.apply("100"));

		Function<String, Integer> f0 = (str) ->Integer.parseInt(str);
		System.out.println(f0.apply("200"));

		String[] args2 = {"82" , "22","3"};
		Arrays.sort(args2, String::compareTo);
		
		for (String string : args2) {
			System.out.println(string);
		}
	}

}
