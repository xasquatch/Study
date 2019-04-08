package convert;

import java.util.Scanner;

public class TestScanner {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하고 엔터치시오");
			int num1 = sc.nextInt();
		System.out.print("정수를 입력하고 엔터치시오");
			int num2 = sc.nextInt();
		System.out.print("연산자(+ - * /)를 입력하고 엔터치시오");
			String op = sc.next();
		double value = 0;
		//op에 따라서
//		switch(op) {
//			case "+" : value = num1+num2;
//				break;
//			case "-" : value = num1-num2;  
//				break;
//			case "*" : value = num1*num2;  
//				break;
//			case "/" : value = (double)num1/(double)num2;  
//				break;
//			default : System.out.println("올바른 연산자를 쓰세요");
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
