package ch04.condition;

import java.util.Scanner;

public class Nestedif {

	public static void main(String[] srgs) {
		String result = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("����");
		int age = sc.nextInt();
		
		System.out.println("��ȣ�ڴ�?");
		boolean withP = sc.nextBoolean();
		
		if(age>=12) {
			result = "12�� ������";
		} else {
			if(withP) {
				result ="��ȣ���־ ����";
			}else {
				result ="��ȣ�ڵ���� �Ұ���";
			}
		}
		
		System.out.println(age+" "+result);
	
		sc.close();
	}
}
