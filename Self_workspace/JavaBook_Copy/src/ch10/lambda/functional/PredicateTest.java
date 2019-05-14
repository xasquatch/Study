package ch10.lambda.functional;

import java.util.function.IntPredicate;

public class PredicateTest {

	static int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
	public static void printSome(IntPredicate pred) {
		for (int i : nums) {
			if (pred.test(i)) {
				System.out.println(i + "\t");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		printSome((num)->{
			return num % 3==0;
		});
		printSome(num->num>5);
	}

}
