package convert;

import java.util.Scanner;

public class TestIf {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요");
		
		int a = sc.nextInt();
//		int b = 200;
//		if(a%2==0) {
//			System.out.println(a+"는 짝수이다");
//		}else {
//			System.out.println(a+"는 홀수이다");
		if(a%5!=0) {
			System.out.println(a+"는 5의배수가 아닙니다");
		}else {
			System.out.println(a+"는 5의배수가 맞습니다");
		}
	sc.close();
	}

}
