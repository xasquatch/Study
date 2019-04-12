package ch04.loop;

import java.util.Scanner;

public class Dowhile {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int i = 0;
		do {
			System.out.println("Á¦°ö±ÙÀÔ·Â");
			i = sc.nextInt();
			System.out.println(Math.sqrt(i)+" "+Math.pow(i, 2));
			
			
		} while (i >0);
		
	}
}
