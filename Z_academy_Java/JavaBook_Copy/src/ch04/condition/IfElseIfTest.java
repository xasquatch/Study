package ch04.condition;

import java.util.Scanner;

public class IfElseIfTest {

	public static void main(String[] args) {

		System.out.println("32~126사이의 정수");
		Scanner sc = new Scanner(System.in);
		int sc1 = sc.nextInt();
		String type = null;
		if(sc1 >= 48 && sc1 <58) {
			type="숫자";
		}else if(sc1 >= 66 && sc1 <91) {
			type="대문자";
		}else if(sc1 >= 97 && sc1 <123) {
			type="소문자";
		}else {
			type = "기타타입";
		}
			
		System.out.println(sc1+" "+type);
		
		sc.close();
	}

}
