package convert;

import java.util.Scanner;

public class TestScanner {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϰ� ����ġ�ÿ�");
			int num1 = sc.nextInt();
		System.out.print("������ �Է��ϰ� ����ġ�ÿ�");
			int num2 = sc.nextInt();
		System.out.print("������(+ - * /)�� �Է��ϰ� ����ġ�ÿ�");
			String op = sc.next();
		double value = 0;
		//op�� ����
//		switch(op) {
//			case "+" : value = num1+num2;
//				break;
//			case "-" : value = num1-num2;  
//				break;
//			case "*" : value = num1*num2;  
//				break;
//			case "/" : value = (double)num1/(double)num2;  
//				break;
//			default : System.out.println("�ùٸ� �����ڸ� ������");
//		}
		if(op.equals("+")) {
			value = num1 + num2;
		}else if(op.equals("-")) {
			value = num1 - num2;
		}else if(op.equals("*")) {
			value = num1 * num2;
		}else if(op.equals("/")) {
			value = num1 / num2;
		}
		System.out.println(num1+" "+op+" "+num2+" = "+value);

	sc.close();
	}

}
