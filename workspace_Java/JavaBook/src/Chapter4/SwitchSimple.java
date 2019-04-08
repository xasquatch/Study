package Chapter4;

import java.util.Random;
import java.util.Scanner;

public class SwitchSimple {

	public static void main(String[] args) {

		Random ran= new Random();
		Scanner sc = new Scanner(System.in);
		
		int level=ran.nextInt(4);
		int level2=sc.nextInt();
		
		String levelString = "";
		
		switch (level) {
		case 0:
			levelString = "운영자관리, 회원관리, 글쓰기, 보기";
			break;
		case 1:
			levelString = "회원관리, 글쓰기, 보기";
			break;
		case 2:
			levelString = "글쓰기, 보기";
			break;
		case 3:
			levelString = "보기";
			break;
		}
		System.out.println("당신의 랜덤권한은: " + levelString);

		
		String levelString2 = "";
		switch (level2) {
		case 0:
			levelString2 = "운영자관리, 회원관리, 글쓰기, 보기";
			break;
		case 1:
			levelString2 = "회원관리, 글쓰기, 보기";
			break;
		case 2:
			levelString2 = "글쓰기, 보기";
			break;
		case 3:
			levelString2 = "보기";
			break;
		}
		System.out.println("당신의 스캔권한은: " + levelString2);
	}

}
