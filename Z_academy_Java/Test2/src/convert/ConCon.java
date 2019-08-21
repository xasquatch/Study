package convert;

import java.util.Scanner;

public class ConCon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요");
			int num1 = sc.nextInt();
		System.out.print("정수를 입력하세요");
			int num2 = sc.nextInt();
		System.out.print("정수를 입력하세요");
			int num3 = sc.nextInt();
		
		
		int min = 0 ;
		
		min = (num1<num2)?num1:num2;
		min = (min<num3)?min:num3;
		

		int max = 0 ;
		
		max = (num1>num2)?num1:num2;
		max = (max>num3)?max:num3;
		
		int sum = 0 ;
		
		sum = num1+num2+num3;
		
		double avg = 0 ;	
			
		avg = sum/3;
		
		System.out.println("입력값 중 가장 큰 수는 "+max+" 입니다.");
		System.out.println("입력값 중 가장 작은 수는 "+min+" 입니다.");
		System.out.println("입력값의 총합 "+sum+"은 입니다");
		System.out.println("입력값의 평균 "+avg+"은 입니다");
		
		
		
		sc.close();
	}

}
