package chapter5;

import java.util.Arrays;

public class ArrayCopy {

	public static void main(String[] args) {	
	
		int [] source = {1,2,3,4,5};
		int [] target = new int [10];
		for(int i = 0; i < source.length; i++) {
			target[i] = source[i];
		}
		System.out.println(Arrays.toString(target));
			
		int [] target2 = new int[10];
		System.arraycopy(source, 0, target2, 0, source.length);
		System.out.println(Arrays.toString(target2));
	
		}
	
	}
