package ch05.advanced;

import java.util.Arrays;

public class ArrayCopy {

	public static void main(String[] args) {

		int [] sc = {1,2,3,4,5};
		int [] target = new int[10];
		for (int i = 0; i < sc.length; i++) {
			target[i] = sc[i];
		}
		System.out.println(Arrays.toString(target));
		
		int [] target2 = new int[10];
		System.arraycopy(sc, 2, target2, 1, sc.length-2);
		System.out.println(Arrays.toString(target2));
	}

}
