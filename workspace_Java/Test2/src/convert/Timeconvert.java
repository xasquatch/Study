package convert;

import java.util.Scanner;

public class Timeconvert {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�ð�(�� ����)�� �Է����ֽʽÿ�");
		int Time = sc.nextInt();

		int Hour = Time/60/60;
		int Min = Time/60-Hour*60;
		int Sec = Time-((Hour*60+Min)*60);
	
		
//		int Hour = Time/3600;
//		int Min = (Time%3600)/60;
//		int Sec = (Time%3600)%60;

		System.out.println(Hour+"�ð�"+Min+"��"+Sec+"��");;
		
		
		sc.close();
	}

}

