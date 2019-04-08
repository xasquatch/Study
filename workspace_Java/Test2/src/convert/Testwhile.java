package convert;

import java.util.Scanner;

public class Testwhile {

	public static void main(String[] args) {
//		사용자가 정수를 입력합니다. 정수 4가 입력되면 프로그램 종료
//		아닐경우에는 hello를 출력합니다
		Scanner sc = new Scanner(System.in);
	int i;
	
		do {
			System.out.println("정수를 입력해주세요. (닫기 커맨드:4)");
			i = sc.nextInt();
			if(i != 4) {
				System.out.println("hello");
				}
					
		}while(i != 4);
			System.out.println("프로그램이 종료가 됩니다.");
		
		
	sc.close();
	}
	
}
