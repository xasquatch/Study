package convert;

import java.util.Scanner;

public class TestElseif {

	public static void main(String[] args) {
		
		System.out.println("����) ������ �Է��Ͻÿ�");
		Scanner sc = new Scanner(System.in);
		
		int score = sc.nextInt();
		char grade = 'F';

	
		if(score > 100) {
			System.out.println("�߸��� �Է��Դϴ�.(0-100)");
		}else if(score >= 90) {
			grade = 'A';
		}else if(score >= 80) {
			grade = 'B';
		}else if(score >= 70) {
			grade = 'C';
		}else if(score >= 60) {
			grade = 'D';
		}
		System.out.println(grade);
		
		sc.close();

	
	
	}
}