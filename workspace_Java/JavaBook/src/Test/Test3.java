package Test;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {

		System.out.println("연도계산 : 연도를 입력하세요.");
		
		Scanner sc = new Scanner(System.in);
		
		int year = sc.nextInt();
		
		if(year % 100 == 0 && year % 400 != 0 ) {
		
			System.out.println("평년입니다.");
			
		}else if(year % 4 == 0) {
			
			System.out.println("윤년입니다.");
			
		}else {
			
			System.out.println("해당없음");
		}
		
		sc.close();
	}

}