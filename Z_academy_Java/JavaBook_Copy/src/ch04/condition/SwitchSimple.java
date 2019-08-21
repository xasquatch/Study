package ch04.condition;

import java.util.Scanner;

public class SwitchSimple {

	public static void main(String[] args) {

		System.out.println("권한 입력 1-4");
		Scanner sc = new Scanner(System.in);
		int level = sc.nextInt();
		String levelString = "";
		switch(level) {
		case 1 : levelString += "관리, ";
		case 2 : levelString += "삭제, ";
		case 3 : levelString += "쓰기, ";
		case 4 : levelString += "보기, ";
		break;
		}
		
		System.out.println(levelString);
		sc.close();
	}

}
