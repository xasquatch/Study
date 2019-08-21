package ch04.condition;

import java.util.Scanner;

public class DayByMonthTest {

	public static void main(String[] args) {
		
		double j = Math.random();
		while(j > 0) {
		System.out.println("달을 입력");
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		int days;
		switch(month) {
		case 2: days=28;
		break;
		case 4:
		case 6:
		case 9:
		case 11: days=30;
		break;
		default : days=31;
		}
		System.out.println(month+" "+days);

		}

	}

}
