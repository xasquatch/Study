package Chapter4;

import java.util.Random;
import java.util.Scanner;

public class SwitchNoBreak {

	public static void main(String[] args) {

		System.out.println("당신의 등급은?");	
		
		Scanner sc = new Scanner(System.in);
		
		String levelString = "";
		String level = sc.next();
		switch (level) {
		
		case "관리자" : 
			levelString +="운영자관리, ";
		case "운영자" : 
			levelString +="회원관리, ";
		case "회원" : 
			levelString +="글쓰기, ";
		default :
			levelString +="보기";
			
		System.out.println("당신의 권한은 : "+levelString);	

	sc.close();
		
		Random rd= new Random();
		
		int level1 = rd.nextInt(3);
		switch (level1) {
		case 3 : 
			levelString +="운영자관리, ";
		case 2 : 
			levelString +="회원관리, ";
		case 0 : 
			levelString +="글쓰기, ";
		default :
			levelString +="보기";
		
		System.out.println("당신의 자동생성권한은 : "+levelString);
		
		
			}
		}
	
	}
	
}	