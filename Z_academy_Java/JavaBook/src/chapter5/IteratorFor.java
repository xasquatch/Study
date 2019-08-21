package chapter5;

import java.util.Random;

public class IteratorFor {

	public static void main(String[] args) {

		int [] datas = new int[100];
		
		Random rd = new Random();
		for(int i = 0;i<datas.length;i++) {
			datas[i] = rd.nextInt(100);
		}
		int evenSum = 0;
		for(int i = 0;i<datas.length;i++) {
			int data = datas[i];
			if(data % 2 == 0) {
				evenSum += data;
			}
		}
		System.out.printf("Â¦¼öµéÀÇ ÇÕ : %d%n", evenSum);
		
		int oddSum = 0;
		for(int data: datas) {
			if(data%2 ==1) {
				oddSum += data;
			}
		}
		System.out.printf("È¦¼öµéÀÇ ÇÕ: %d%n", oddSum);

	}

}
