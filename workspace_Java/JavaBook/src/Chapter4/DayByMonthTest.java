package Chapter4;

import java.util.Scanner;

public class DayByMonthTest {

	public static void main(String[] args) {

		System.out.println("달 입력해");
		Scanner sc = new Scanner(System.in);

		int Month = sc.nextInt();
		int days = 0;
		switch(Month) {
		case 2 :
			days = 28 ;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		default:
			days = 31;
		}
		System.out.printf("%d월은 %d일까지 있습니다.",Month, days);
		sc.close();
	}

}
