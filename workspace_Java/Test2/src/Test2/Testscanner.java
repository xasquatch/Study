package Test2;

import java.util.Scanner;  //Ctrl + Shift + O

public class Testscanner {

	public static void main(String[] args) {
			
			
			Scanner sc = new Scanner(System.in); //new : �޸𸮿� �Ҵ��� ������� �����
			System.out.print("������ �Է��ϰ� ����ġ�ÿ�");
			int num1 = sc.nextInt();
			System.out.print("������ �Է��ϰ� ����ġ�ÿ�");
			int num2 = sc.nextInt();
			System.out.print("���ڸ� �Է��ϰ� ����ġ�ÿ�");
			String op = sc.next();
			
			System.out.print(num1+" "+num2+" "+op);
			
		sc.close();
		
		}
	
}