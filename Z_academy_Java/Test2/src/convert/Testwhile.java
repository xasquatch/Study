package convert;

import java.util.Scanner;

public class Testwhile {

	public static void main(String[] args) {
//		����ڰ� ������ �Է��մϴ�. ���� 4�� �ԷµǸ� ���α׷� ����
//		�ƴҰ�쿡�� hello�� ����մϴ�
		Scanner sc = new Scanner(System.in);
	int i;
	
		do {
			System.out.println("������ �Է����ּ���. (�ݱ� Ŀ�ǵ�:4)");
			i = sc.nextInt();
			if(i != 4) {
				System.out.println("hello");
				}
					
		}while(i != 4);
			System.out.println("���α׷��� ���ᰡ �˴ϴ�.");
		
		
	sc.close();
	}
	
}
