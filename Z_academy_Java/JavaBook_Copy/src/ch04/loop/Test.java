package ch04.loop;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		
		int i = (int)(Math.random()*100);
		System.out.println("0~100���� ���ڸ� �Է��ϼ���");
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int j = sc.nextInt();
			if(j>i) {
				System.out.println("�Է��� ������ ���� �� Ů�ϴ�.");
			}else if(j<i) {
				System.out.println("�Է��� ������ ���� �� �۽��ϴ�.");
			}else {
				System.out.println("����");
				break;
			}
			
		}
		sc.close();
	}

}
