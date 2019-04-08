package Array;

import java.util.Scanner;

public class Arrayex3 {

	public static void main(String[] args) {

		String[] name = new String[5];
		int count = 0;
		Scanner sc = new Scanner(System.in);
		int input;
		
		do {
		System.out.println("input<1>, searching<2>, all view<3>, exit<4>");
		input = sc.nextInt();
		if(input != 1 && input != 2 && input != 3) {
			System.out.println("올바른 값을 입력해주세요");	
			input = 4;
		} 
			
			switch(input) {
			case 1 : System.out.println("학생 이름 입력");
				name[count] = sc.next();
				count++;
				break;
			case 2 : System.out.println("검색할 학생 이름 입력");
				String str = sc.next();
				for(int i = 0; i < count; i++) {
					if (str.equals(name[i])) {
						System.out.println("결과 : " + str);
					}
				}
				break;
			case 3 :
				for(int i = 0; i<count; i++) {
					System.out.println("name["+i+"] = "+name[i]);
				}
				break;
			}
			
		}while(input !=4);
		System.out.println("종료");
		
		sc.close();	
	}
}
