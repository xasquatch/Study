package Array;

import java.util.Scanner;

public class Arrayex2 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int[] i = new int[5];
		int max = i[0];
				
		for(int j = 0; j < i.length; j++) {
		
			System.out.println("������ �Է����ּ���");
			i[j] = sc.nextInt();
			
			if(i[j] > max) {	
				max = i[j];
			}
		
		
		
		}
			System.out.println("�ִ밪 = "+max);
	sc.close();
	}

}
