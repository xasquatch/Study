package ch04.loop;

import java.util.Random;
import java.util.Scanner;

public class GuguQuiz {

	public static void main(String[] args) {
		
		System.out.println("������ ���� ���߼���");
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		while(true) {
			int i = rd.nextInt(9)+1;
			int j = rd.nextInt(9)+1;

			while(true) {
				System.out.printf("%d*%d?",i,j);
	
				int z = sc.nextInt();
				
					if(i*j == z) {
						System.out.println("����");
						break;
					}else {
						System.out.println("Ʋ�Ƚ��ϴ�.");
					}
				
			}
		}
	}
}
