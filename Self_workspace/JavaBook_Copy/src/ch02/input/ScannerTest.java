package ch02.input;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("문자열입력");
		String line = sc.nextLine();
		System.out.printf("입력한 문자열: %s%n",line);
		System.out.println("정수입력");
		int i = sc.nextInt();
		System.out.printf("입력한 정수 : %d%n",i);
		System.out.println("실수입력");
		double d = sc.nextDouble();
		System.out.printf("입력한 실수 : %f%n",d);
		System.out.println("불리언입력");
		boolean b = sc.hasNextBoolean();
		System.out.printf("입력한 불리언 : %b",b);
		
	sc.close();
	}

}
