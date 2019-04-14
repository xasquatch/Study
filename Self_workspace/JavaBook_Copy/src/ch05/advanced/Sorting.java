package ch05.advanced;

import java.util.Arrays;
import java.util.Random;

public class Sorting {

	public static void main(String[] args) {

		Random rd = new Random();
		int temp = 0;
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(100);
		}
		System.out.println("ÃÊ±â");
		for (int i : arr) {
			System.out.printf("%d\t",i);
		}
		System.out.println();
		
		
//		for (int i = 0; i < arr.length-1; i++) {
//			for (int j = 0; j < arr.length-1; j++) {
//				if (arr[j]>arr[j+1]) {
//					temp = arr[j];
//					arr[j] = arr[j+1];
//					arr[j+1] = temp;
//				}
//			}
//		}

		Arrays.sort(arr);
		
		for (int i : arr) {

			System.out.printf("%d\t",i);
			
		}
	}

}
