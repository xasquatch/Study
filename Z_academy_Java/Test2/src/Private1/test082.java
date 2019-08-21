package Private1;

import java.util.Scanner;

public class test082 {
	
	public static void main(String[] args) {
		
		
		System.out.println("숫자를 1~10중 입력해주세요");
		Scanner sc = new Scanner(System.in);
		
		int i = sc.nextInt();
		
		do {
			
			System.out.println("결과값 : "+i+"연산실행");
			i += 1;
						
			
		}while(i<11);
		
		
	sc.close();
	}
}
