package Private1;

import java.util.Scanner;

public class switchpra {

	public static void main(String[] args) {

		System.out.println("좋아하는 계절을 숫자로 입력해주세요 봄(0)~겨울(3)");		
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		String j[] = {"봄","여름","가을","겨울"};
		System.out.println("좋아하는 월을 숫자로 입력해주세요.");		
		int x = sc.nextInt();
		
		switch(x) {
		case 1 : 
			System.out.println("1월");
			break;
		case 2 : 
			System.out.println("2월");
			break;
		case 3 : 
			System.out.println("3월");
			break;
		case 4 : 
			System.out.println("4월");
			break;
		case 5 : 
			System.out.println("5월");
			break;
		case 6 : 
			System.out.println("6월");
			break;
		case 7 : 
			System.out.println("7월");
			break;
		case 8 : 
			System.out.println("8월");
			break;
		case 9 : 
			System.out.println("9월");
			break;
		case 10 : 
			System.out.println("10월");
			break;
		case 11 : 
			System.out.println("11월");
			break;
		case 12 : 
			System.out.println("12월");
			break;
		}
			
		
		System.out.println(j[i]);
		
		sc.close();

	}

}
