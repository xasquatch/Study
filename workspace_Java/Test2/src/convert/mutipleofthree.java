package convert;

import java.util.Scanner;

public class mutipleofthree {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� �Է��Ͻÿ�");
		
		int i = sc.nextInt();
		if(i % 3 == 0) {
			System.out.println("�Է��� ���� 3�� ����Դϴ�.");
			}else {
		System.out.println("3�ǹ���� �ƴմϴ�.");
			}
	sc.close();
	}
}
