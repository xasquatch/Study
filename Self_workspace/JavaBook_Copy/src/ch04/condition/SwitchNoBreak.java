package ch04.condition;

import java.util.Scanner;

public class SwitchNoBreak {

	public static void main(String[] args) {

		System.out.println("���� �Է�");
		Scanner sc = new Scanner(System.in);
		String levelString = "";
		String level = sc.next();
		switch(level) {
		case "������":
			levelString += "��ڰ���";
		case "���":
			levelString += "ȸ������";
		case "ȸ��":
			levelString += "�۾���";
		default:
			levelString += "����";
		}
		System.out.println("���� : "+levelString);
	}

}
