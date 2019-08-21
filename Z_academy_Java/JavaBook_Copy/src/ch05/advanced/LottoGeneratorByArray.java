package ch05.advanced;

import java.util.Arrays;
import java.util.Random;

public class LottoGeneratorByArray {

	public static void main(String[] args) {

		int[] st= new int[6];
		int[] fb = new int[46];
		int cnt = 0;
		Random rd = new Random();
		while (cnt<6) {
			int index = rd.nextInt(45);

			int ball = fb[index];

			if (ball == 0) {
				st[cnt] = index + 1;

				fb[index] = 11122;

				cnt++;	
			}else {
				System.out.println("ºñ»ó!!!!!!!!!!!!!!!"+ball);
			}
		}
		Arrays.sort(st);
		System.out.println(Arrays.toString(st));
	}

}
