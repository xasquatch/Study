package ch04.condition;

import java.util.Scanner;

public class Nestedif {

	public static void main(String[] srgs) {
		String result = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("나이");
		int age = sc.nextInt();
		
		System.out.println("보호자는?");
		boolean withP = sc.nextBoolean();
		
		if(age>=12) {
			result = "12세 관람가";
		} else {
			if(withP) {
				result ="보호자있어서 가능";
			}else {
				result ="보호자도없어서 불가능";
			}
		}
		
		System.out.println(age+" "+result);
	
		sc.close();
	}
}
