package ch04.condition;

import java.util.Scanner;

public class IfElseIfTest {

	public static void main(String[] args) {

		System.out.println("32~126������ ����");
		Scanner sc = new Scanner(System.in);
		int sc1 = sc.nextInt();
		String type = null;
		if(sc1 >= 48 && sc1 <58) {
			type="����";
		}else if(sc1 >= 66 && sc1 <91) {
			type="�빮��";
		}else if(sc1 >= 97 && sc1 <123) {
			type="�ҹ���";
		}else {
			type = "��ŸŸ��";
		}
			
		System.out.println(sc1+" "+type);
		
		sc.close();
	}

}
