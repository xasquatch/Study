package ch04.loop;

import java.util.Scanner;

public class TimesTableFor1 {

	public static void main(String[] args) {

		System.out.println("출력할 단");
		Scanner sc = new Scanner(System.in);
		int dan = sc.nextInt();
		for(int i = 1;i<=9;i++) {
			System.out.println(dan+"×"+i+"＝"+(dan*i));
			}
		
	}

}
