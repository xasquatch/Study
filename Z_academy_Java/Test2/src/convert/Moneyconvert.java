package convert;

import java.util.Scanner;

public class Moneyconvert {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			System.out.print("�й��� ���� �׼��� �Է����ֽÿ�");
				int Money = sc.nextInt();
				
				int won50000 = Money/50000;
				Money %= 50000;
				int won10000 = Money/10000;  
				Money %= 10000;
				int won05000 = Money/5000;
				Money %= 5000;
				int won01000 = Money/1000;
				Money %= 1000;
				int won00500 = Money/500;
				Money %= 500;
				int won00100 = Money/100;
				Money %= 100;
				int won00050 = Money/50;
				Money %= 50;
				int won00010 = Money/10;
				Money %= 10;
				int won00001 = Money/1;
				Money %= 1;
		System.out.println(" 5���� : "+won50000+" 1���� : "+won10000);
		System.out.println(" 5õ�� : "+won05000+" 1õ�� : "+won01000);
		System.out.println(" 5��� : "+won00500+" 1��� : "+won00100);
		System.out.println(" 5�ʿ� : "+won00050+" 1�ʿ� : "+won00010);
		System.out.println(" 1�� : "+won00001);
		
		
		sc.close();
	}
}