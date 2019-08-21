package convert;

import java.util.Scanner;

public class mutipleofthree {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("수를 입력하시오");
		
		int i = sc.nextInt();
		if(i % 3 == 0) {
			System.out.println("입력한 값은 3의 배수입니다.");
			}else {
		System.out.println("3의배수가 아닙니다.");
			}
	sc.close();
	}
}
