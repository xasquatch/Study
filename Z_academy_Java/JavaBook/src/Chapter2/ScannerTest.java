package Chapter2;

import java.util.Scanner;

public class ScannerTest {

	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڿ��� �Է��ϼ���.");
		String line = sc.nextLine();
		System.out.printf("�Է��� ���ڿ�: %s%n", line);
		System.out.println("������ �Է��ϼ���.");
		int num1 = sc.nextInt();
		System.out.printf("�Է��� ����: %d%n", num1);
		System.out.println("�Ǽ��� �Է��ϼ���.");
		double num2 = sc.nextDouble();
		System.out.printf("�Է��� �Ǽ�: %f%n", num2);
		System.out.println("�Ҹ��� �Է��ϼ���.");
		boolean bool = sc.nextBoolean();
		System.out.printf("�Է��� �Ҹ���: %b%n", bool);
		sc.close();
		
		
		
	}
}
