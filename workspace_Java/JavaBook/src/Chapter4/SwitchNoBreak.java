package Chapter4;

import java.util.Random;
import java.util.Scanner;

public class SwitchNoBreak {

	public static void main(String[] args) {

		System.out.println("����� �����?");	
		
		Scanner sc = new Scanner(System.in);
		
		String levelString = "";
		String level = sc.next();
		switch (level) {
		
		case "������" : 
			levelString +="��ڰ���, ";
		case "���" : 
			levelString +="ȸ������, ";
		case "ȸ��" : 
			levelString +="�۾���, ";
		default :
			levelString +="����";
			
		System.out.println("����� ������ : "+levelString);	

	sc.close();
		
		Random rd= new Random();
		
		int level1 = rd.nextInt(3);
		switch (level1) {
		case 3 : 
			levelString +="��ڰ���, ";
		case 2 : 
			levelString +="ȸ������, ";
		case 0 : 
			levelString +="�۾���, ";
		default :
			levelString +="����";
		
		System.out.println("����� �ڵ����������� : "+levelString);
		
		
			}
		}
	
	}
	
}	