package Array;

import java.util.Scanner;

public class Arrayex3 {

	public static void main(String[] args) {

		String[] name = new String[5];
		int count = 0;
		Scanner sc = new Scanner(System.in);
		int input;
		
		do {
		System.out.println("input<1>, searching<2>, all view<3>, exit<4>");
		input = sc.nextInt();
		if(input != 1 && input != 2 && input != 3) {
			System.out.println("�ùٸ� ���� �Է����ּ���");	
			input = 4;
		} 
			
			switch(input) {
			case 1 : System.out.println("�л� �̸� �Է�");
				name[count] = sc.next();
				count++;
				break;
			case 2 : System.out.println("�˻��� �л� �̸� �Է�");
				String str = sc.next();
				for(int i = 0; i < count; i++) {
					if (str.equals(name[i])) {
						System.out.println("��� : " + str);
					}
				}
				break;
			case 3 :
				for(int i = 0; i<count; i++) {
					System.out.println("name["+i+"] = "+name[i]);
				}
				break;
			}
			
		}while(input !=4);
		System.out.println("����");
		
		sc.close();	
	}
}
