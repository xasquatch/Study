package ch04.loop;

import java.util.Scanner;

public class TimesTableWhile1 {

	public static void main(String[] args) {
		
		System.out.println("´Ü");
		Scanner sc = new Scanner(System.in);
		int dan = sc.nextInt();
		int i = 1;
		
		while(i <=9) {
			System.out.println(dan*i);
			i++;
		}
	}
}
