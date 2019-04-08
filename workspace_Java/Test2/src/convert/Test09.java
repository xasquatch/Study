package convert;

import java.util.Scanner;

public class Test09 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하시오");
		

		int score = sc.nextInt();
		char grade='A';
		
		switch(score/10) {
		case 10 : 
			grade = 'A';
			break;
		case 9 : 
			grade = 'A';
			break;		
		case 8 : 
			grade = 'B';
			break;
		case 7 : 
			grade = 'C';
			break;
		case 6 : 
			grade = 'D';
			break;
		default : grade = 'F';
		}
			System.out.println(grade);
	sc.close();
	}
}