package Test;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int i = sc.nextInt();
		String x = "";
		
		if(i>90 && i<=100) {
			x = "A";
			System.out.println(x+"�����Դϴ�");
		}else if(i>70 && i<=90) {
			x = "B";
			System.out.println(x+"�����Դϴ�");
		}else if(i>50 && i<=70) {
			x = "C";
			System.out.println(x+"�����Դϴ�");
		}else if(i>50 && i<=70) {
			x = "D";
			System.out.println(x+"�����Դϴ�");
		}else if(i>50 && i<=0) {
			x = "F";
			System.out.println(x+"�����Դϴ�");
		}else {
			System.out.println("0~100�� ������ �ٽ� �Է����ּ���");
		
		}
	}
}

