package convert;

import java.util.Scanner;

public class ConCon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ���");
			int num1 = sc.nextInt();
		System.out.print("������ �Է��ϼ���");
			int num2 = sc.nextInt();
		System.out.print("������ �Է��ϼ���");
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
		
		System.out.println("�Է°� �� ���� ū ���� "+max+" �Դϴ�.");
		System.out.println("�Է°� �� ���� ���� ���� "+min+" �Դϴ�.");
		System.out.println("�Է°��� ���� "+sum+"�� �Դϴ�");
		System.out.println("�Է°��� ��� "+avg+"�� �Դϴ�");
		
		
		
		sc.close();
	}

}
