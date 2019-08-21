package Array;

import java.util.Scanner;

public class Arrayex1 {

	public static void main(String[] args) {
		
		
	
	Scanner sc = new Scanner(System.in);
		 
		int [] i = new int[5];
		
		for(int j = 0; j<i.length; j++) {

			System.out.println("5개의 정수를 입력해주시오");
			i[j] = sc.nextInt();
			
			
				
		}
	
		for(int j = 0; j < i.length; j++) {
			System.out.println("i[" + j + "] = " + i[j]);
			
		}
		
	sc.close();
		
	}
		
}