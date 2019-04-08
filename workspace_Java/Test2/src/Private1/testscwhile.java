package Private1;

import java.util.Scanner;

public class testscwhile {

	public static void main(String[] args) {
		
		int i = 0;
		int n = 0;
		double sum = 0;
		Scanner sc = new Scanner(System.in);
		
		while((i = sc.nextInt()) != 0) {
			sum += i;
			n++; //입력된 개수를 나타낸다.
			System.out.println("입력된 수의 개수는 "+n+"개이며 평균은 "+sum/n+"입니다.");
			
		}

		System.out.println("입력된 수의 개수는 0 입니다.");		
		
		sc.close();
		
	}
}
