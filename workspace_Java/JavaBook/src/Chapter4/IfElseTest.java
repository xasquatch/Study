package Chapter4;

import java.util.Random;

public class IfElseTest {
	
	public static void main(String[] args) {
		
		String result = null;
		Random myRandom = new Random();
		
		System.out.println("ū��?, ������?");
		int num1 = myRandom.nextInt(100);	//0~99 ������ ����
		if(num1 >=50) {
			result = "ū��";
		}else {
			
			result="������";
		}
		System.out.printf("%d�� %s�̴�%n",num1,result);

		System.out.println("¦���ϱ�?");
		int num2 = myRandom.nextInt(10);
		
		if(num2 % 2 == 0) {
			result = "¦��";
		}else {
			
			result="Ȧ��";
		}
		System.out.printf("%d�� %s�̴�%n",num2,result);

		result = (num2%2==0)? "¦��":"Ȧ��";
		System.out.printf("%d�� %s�̴�%n",num2,result);
		
	}
	
	
	
}
