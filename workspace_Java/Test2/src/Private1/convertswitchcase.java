package Private1;

import java.util.Scanner;

public class convertswitchcase {
	public static void main(String[] args) {
	
		System.out.println("���ϴ� ������ �� ���� �Է����ּ���");
		
		Scanner sc = new Scanner(System.in);
		
		int i = sc.nextInt();
		int j = sc.nextInt();
		
		switch(i) {
		case 10 : 
			j += 5;
			break;
		case 20 : 
			j += 10;
			break;
		case 30 : 
			j += 20;
			break;
		case 40 : 
			j += 30;
			break;
		
		default : j += 100;
		}
		System.out.println(i+"�� "+j);
		
		sc.close();
	}
}
