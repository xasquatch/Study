package Test2;

import java.util.Scanner;  //Ctrl + Shift + O

public class Testscanner {

	public static void main(String[] args) {
			
			
			Scanner sc = new Scanner(System.in); //new : 메모리에 할당을 받으라는 예약어
			System.out.print("정수를 입력하고 엔터치시오");
			int num1 = sc.nextInt();
			System.out.print("정수를 입력하고 엔터치시오");
			int num2 = sc.nextInt();
			System.out.print("문자를 입력하고 엔터치시오");
			String op = sc.next();
			
			System.out.print(num1+" "+num2+" "+op);
			
		sc.close();
		
		}
	
}