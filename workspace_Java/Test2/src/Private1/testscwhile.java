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
			n++; //�Էµ� ������ ��Ÿ����.
			System.out.println("�Էµ� ���� ������ "+n+"���̸� ����� "+sum/n+"�Դϴ�.");
			
		}

		System.out.println("�Էµ� ���� ������ 0 �Դϴ�.");		
		
		sc.close();
		
	}
}
