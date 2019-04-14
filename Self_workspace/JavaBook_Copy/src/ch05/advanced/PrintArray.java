package ch05.advanced;

import java.util.Arrays;

public class PrintArray {

	public static void main(String[] args) {

		String [] strs = {"Hello","Java","World"};
		String [] a = new String[3];
		a[0] = "Hello";
		a[1] = "Java";
		a[2] = "World";
		
		String [] b = new String[]{"Hello","Java","World"};
		
		
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(strs));
		
	}

}
