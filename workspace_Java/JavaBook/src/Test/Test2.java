package Test;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

		int x_dot = 500;
		int y_dot = 500;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("x(최대:"+x_dot+"))의 좌표를 입력하시오");

		int i = sc.nextInt();
		
		System.out.println("y(최대:"+y_dot+"))의 좌표를 입력하시오");

		int j = sc.nextInt();

		int a = 50;
		int b = 50;
		int c = 100;
		int d = 100;

		int x = c - a;
		int y = d - b;
		
		if(i>=x && i<=c && j>=y && j<= d) {
			
			System.out.println("사각형 안에 점이 있습니다.");
			
		}else {
			
			System.out.println("사각형 안에 점이 없습니다.");
						
		}
	
		sc.close();
		
	}

}
