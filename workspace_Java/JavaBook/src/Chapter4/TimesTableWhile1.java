package Chapter4;

import java.util.Scanner;

public class TimesTableWhile1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("����� ���� �Է��ϼ���");
		Scanner sc = new Scanner(System.in);
		int dan = sc.nextInt();
		
		int i = 1;
		while (i<=9) {
			System.out.print(dan + "*" + i + "=" +(dan*i) + "\t");
			i++;
			
		}
	}

}
