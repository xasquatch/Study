package Private1;

import java.util.Scanner;

public class test082 {
	
	public static void main(String[] args) {
		
		
		System.out.println("���ڸ� 1~10�� �Է����ּ���");
		Scanner sc = new Scanner(System.in);
		
		int i = sc.nextInt();
		
		do {
			
			System.out.println("����� : "+i+"�������");
			i += 1;
						
			
		}while(i<11);
		
		
	sc.close();
	}
}
