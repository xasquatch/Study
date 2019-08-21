package ch04.condition;

import java.util.Random;

public class IfElseTest {

	public static void main(String[] args) {

		String result = null;
		Random myRandom = new Random();
		
		System.out.println("큰수? 작은수?");
		int num1 = myRandom.nextInt(100);
		if(num1 >=50) {
			result = "큰 수";
		}else {
			result = "작은 수";
		}
		System.out.println(num1+" "+result);
		
		result = num1 % 2 == 0?"짝수":"홀수";
		System.out.println(result+""+num1);
	}

}
