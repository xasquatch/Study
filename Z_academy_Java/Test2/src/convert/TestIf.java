package convert;

import java.util.Scanner;

public class TestIf {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("������ �Է��ϼ���");
		
		int a = sc.nextInt();
//		int b = 200;
//		if(a%2==0) {
//			System.out.println(a+"�� ¦���̴�");
//		}else {
//			System.out.println(a+"�� Ȧ���̴�");
		if(a%5!=0) {
			System.out.println(a+"�� 5�ǹ���� �ƴմϴ�");
		}else {
			System.out.println(a+"�� 5�ǹ���� �½��ϴ�");
		}
	sc.close();
	}

}
