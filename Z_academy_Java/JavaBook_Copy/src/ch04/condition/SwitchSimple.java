package ch04.condition;

import java.util.Scanner;

public class SwitchSimple {

	public static void main(String[] args) {

		System.out.println("���� �Է� 1-4");
		Scanner sc = new Scanner(System.in);
		int level = sc.nextInt();
		String levelString = "";
		switch(level) {
		case 1 : levelString += "����, ";
		case 2 : levelString += "����, ";
		case 3 : levelString += "����, ";
		case 4 : levelString += "����, ";
		break;
		}
		
		System.out.println(levelString);
		sc.close();
	}

}
