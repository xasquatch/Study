package ch05.advanced;

import java.util.Random;

public class IteratorFor {

	public static void main(String[] args) {
		int [] data = new int[100];
		Random rd = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = rd.nextInt(100);
		}
		
		int even = 0;
		for (int i = 0; i < data.length; i++) {
			int data1 = data[i];
			if(data1%2==0) {
				even += data1;
			}
		}
		System.out.printf("Â¦¼öÇÕ%d",even);

		int odd = 0;
		for (int i = 0; i < data.length; i++) {
			int data1 = data[i];
			if(data1%2!=0) {
				odd += data1;
			}
		}
		System.out.printf("È¦¼öÇÕ%d\n",odd);

		System.out.println(odd+even);
	}

}
