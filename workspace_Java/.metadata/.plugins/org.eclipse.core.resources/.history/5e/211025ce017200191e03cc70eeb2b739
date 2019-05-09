package Test;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);

		System.out.println("1~99 »çÀÌÀÇ Á¤¼ö¸¦ ÀÔ·Â ÇÏ½Ã¿À");
		
		int num = sc.nextInt();
		
		if(num < 10 && num % 3 ==0) System.out.println("¹Ú¼öÂ¦");
		else if(num>=10) {
			int digit1 = num%10;
			int digit10 = num/100;
			
			int cnt = 0;
			if(digit1 == 0 | digit1 % 3 == 0) cnt++;
			if(digit10 % 3 ==0) cnt++;
			
			if(cnt == 2) System.out.println("¹Ú¼öÂ¦Â¦");
			else if(cnt == 1) System.out.println("¹Ú¼öÂ¦Â¦");
			
		}
	}

}
