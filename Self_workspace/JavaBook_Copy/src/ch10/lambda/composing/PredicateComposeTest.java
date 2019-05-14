package ch10.lambda.composing;

import java.util.function.IntPredicate;

public class PredicateComposeTest {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		IntPredicate ip1 = i -> i%2 ==0;
		IntPredicate ip2 = i -> i%3 ==0;

		IntPredicate ip3 = ip1.and(ip2);
		for (int num : nums) {
			if (ip3.test(num)) {
				System.out.println("2와 3의 공배수 : "+num);
			}
			if (ip1.negate().test(num)) {
				System.out.println("2의 배수가 아닌수 : "+num);
			}
		}
		
	}

}
