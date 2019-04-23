package ch11.system;

import java.util.Scanner;

public class BasicIO {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)){
			String str = sc.nextLine();
			System.out.println("일반출력: "+str);
			System.err.println("오류출력: "+str);
		}
	}
}
