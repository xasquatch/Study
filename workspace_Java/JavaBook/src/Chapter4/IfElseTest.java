package Chapter4;

import java.util.Random;

public class IfElseTest {
	
	public static void main(String[] args) {
		
		String result = null;
		Random myRandom = new Random();
		
		System.out.println("큰수?, 작은수?");
		int num1 = myRandom.nextInt(100);	//0~99 사이의 정수
		if(num1 >=50) {
			result = "큰수";
		}else {
			
			result="작은수";
		}
		System.out.printf("%d는 %s이다%n",num1,result);

		System.out.println("짝수일까?");
		int num2 = myRandom.nextInt(10);
		
		if(num2 % 2 == 0) {
			result = "짝수";
		}else {
			
			result="홀수";
		}
		System.out.printf("%d는 %s이다%n",num2,result);

		result = (num2%2==0)? "짝수":"홀수";
		System.out.printf("%d는 %s이다%n",num2,result);
		
	}
	
	
	
}
