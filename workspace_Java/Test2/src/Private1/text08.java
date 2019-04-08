package Private1;

import java.util.Scanner;

public class text08 {

	public static void main(String[] args) {

		System.out.println("가, 나, 다, 라, 마 중에서 하나의 단어를 입력해주세요");
		Scanner sc = new Scanner(System.in);
		String c = sc.next();
		
				
		switch(c) {
			case "가" : System.out.println("정답입니다.");
			break;
			case "나" : System.out.println("정답입니다.");
			break;
			case "다" : System.out.println("정답입니다.");
			break;
			default : System.out.println("잘못 입력된 값입니다.");
		
		}
	
	sc.close();
	
	}
	
}
