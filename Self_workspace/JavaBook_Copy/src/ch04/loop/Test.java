package ch04.loop;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		
		int i = (int)(Math.random()*100);
		System.out.println("0~100까지 숫자를 입력하세요");
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int j = sc.nextInt();
			if(j>i) {
				System.out.println("입력한 숫자의 값이 더 큽니다.");
			}else if(j<i) {
				System.out.println("입력한 숫자의 값이 더 작습니다.");
			}else {
				System.out.println("정답");
				break;
			}
			
		}
		sc.close();
	}

}
