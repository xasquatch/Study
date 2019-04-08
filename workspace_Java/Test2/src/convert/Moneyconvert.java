package convert;

import java.util.Scanner;

public class Moneyconvert {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			System.out.print("분배할 돈의 액수를 입력해주시오");
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
		System.out.println(" 5만원 : "+won50000+" 1만원 : "+won10000);
		System.out.println(" 5천원 : "+won05000+" 1천원 : "+won01000);
		System.out.println(" 5백원 : "+won00500+" 1백원 : "+won00100);
		System.out.println(" 5십원 : "+won00050+" 1십원 : "+won00010);
		System.out.println(" 1원 : "+won00001);
		
		
		sc.close();
	}
}