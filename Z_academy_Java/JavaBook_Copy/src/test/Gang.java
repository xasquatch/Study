package test;

import java.util.Random;
import java.util.Scanner;

public class Gang {

	public static void main(String[] args) {

		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("Ű�����Է�");
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.printf("\t\t\t\t\t��   %d\n",x*y);
			
			int i = rd.nextInt(8)+2;
			int j = rd.nextInt(7)+3;
			System.out.printf("%d��%d=?\n",i,j);
			System.out.println(i*j);
		}
		
	}

}
