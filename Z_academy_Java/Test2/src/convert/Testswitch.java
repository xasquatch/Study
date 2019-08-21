package convert;

import java.util.Scanner;

public class Testswitch {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
				
		switch(a) {
		case 10 : 
			System.out.println("Value 10");
			break;
		case 100 : 
			System.out.println("Value 100");
			break;
		case 1000 : 
			System.out.println("Value 1000");
			break;
		default : System.out.println("Value .....");
		}
		
		sc.close();
		
	}

}
