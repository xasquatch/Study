package Test;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {

		System.out.println("������� : ������ �Է��ϼ���.");
		
		Scanner sc = new Scanner(System.in);
		
		int year = sc.nextInt();
		
		if(year % 100 == 0 && year % 400 != 0 ) {
		
			System.out.println("����Դϴ�.");
			
		}else if(year % 4 == 0) {
			
			System.out.println("�����Դϴ�.");
			
		}else {
			
			System.out.println("�ش����");
		}
		
		sc.close();
	}

}