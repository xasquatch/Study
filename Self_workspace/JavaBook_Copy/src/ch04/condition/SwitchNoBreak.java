package ch04.condition;

import java.util.Scanner;

public class SwitchNoBreak {

	public static void main(String[] args) {

		System.out.println("권한 입력");
		Scanner sc = new Scanner(System.in);
		String levelString = "";
		String level = sc.next();
		switch(level) {
		case "관리자":
			levelString += "운영자관리";
		case "운영자":
			levelString += "회원관리";
		case "회원":
			levelString += "글쓰기";
		default:
			levelString += "보기";
		}
		System.out.println("권한 : "+levelString);
	}

}
