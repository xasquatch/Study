package ch02.input;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("���ڿ��Է�");
		String line = sc.nextLine();
		System.out.printf("�Է��� ���ڿ�: %s%n",line);
		System.out.println("�����Է�");
		int i = sc.nextInt();
		System.out.printf("�Է��� ���� : %d%n",i);
		System.out.println("�Ǽ��Է�");
		double d = sc.nextDouble();
		System.out.printf("�Է��� �Ǽ� : %f%n",d);
		System.out.println("�Ҹ����Է�");
		boolean b = sc.hasNextBoolean();
		System.out.printf("�Է��� �Ҹ��� : %b",b);
		
	sc.close();
	}

}
