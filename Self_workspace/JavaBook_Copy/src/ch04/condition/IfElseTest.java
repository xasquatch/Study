package ch04.condition;

import java.util.Random;

public class IfElseTest {

	public static void main(String[] args) {

		String result = null;
		Random myRandom = new Random();
		
		System.out.println("ū��? ������?");
		int num1 = myRandom.nextInt(100);
		if(num1 >=50) {
			result = "ū ��";
		}else {
			result = "���� ��";
		}
		System.out.println(num1+" "+result);
		
		result = num1 % 2 == 0?"¦��":"Ȧ��";
		System.out.println(result+""+num1);
	}

}
