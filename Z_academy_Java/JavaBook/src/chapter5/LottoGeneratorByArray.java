package chapter5;

import java.util.Arrays;
import java.util.Random;

public class LottoGeneratorByArray {

	public static void main(String[] args) {
		int[] selected = new int[6];
		int[] fullBall = new int[46];
		
		int cnt = 0;
		Random rand = new Random();
		while (cnt<6) {
			int index = rand.nextInt(45);
			int ball = fullBall[index];
			if(ball ==0) {
				selected[cnt] = index +1;
				fullBall[index] = -1;
				cnt++;
				}
			}
			Arrays.sort(selected);
			System.out.println(Arrays.toString(selected));
		
	}

}
