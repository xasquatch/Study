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
			levelString = "��ڰ���, ȸ������, �۾���, ����";
			break;
		case 1:
			levelString = "ȸ������, �۾���, ����";
			break;
		case 2:
			levelString = "�۾���, ����";
			break;
		case 3:
			levelString = "����";
			break;
		}
		System.out.println("����� ����������: " + levelString);

		
		String levelString2 = "";
		switch (level2) {
		case 0:
			levelString2 = "��ڰ���, ȸ������, �۾���, ����";
			break;
		case 1:
			levelString2 = "ȸ������, �۾���, ����";
			break;
		case 2:
			levelString2 = "�۾���, ����";
			break;
		case 3:
			levelString2 = "����";
			break;
		}
		System.out.println("����� ��ĵ������: " + levelString2);
	}

}
