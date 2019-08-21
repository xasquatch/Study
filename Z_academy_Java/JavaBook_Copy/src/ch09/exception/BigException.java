package ch09.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;

class SimpleException{
	
	public void name() {
		int[] intArray = {10};
		try {
			System.out.println(intArray[2]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭���ܿ���");
			
			
		}
		System.out.println(getClass()+"����");
	}
	
}

class TryCatchFlow{
	public void name() {
		
		try {
			int num = new Random().nextInt(2);
			System.out.println("code 1, num:"+num);
			int i = 1/num;
			System.out.println("code 2 = ���ܾ���");
		} catch (ArithmeticException e) {
			System.out.println("code 3 - ����ó�� �Ϸ�");
		}
		System.out.println("code4");
	}
}

class MultiExceptionHandling{
	public void name() {
		try {
			Class.forName("ch09.exception.BigException");
			new FileInputStream("Hello.java");
			DriverManager.getConnection("HELLO");
		} catch (ClassNotFoundException e) {
			e.getMessage();
		}catch (FileNotFoundException e) {
			e.getMessage();
		}catch (SQLException e) {
			e.getMessage();
		}
		System.out.println("����");
	}
	
}

class HierarchyException{
	
	public void name() {
		String src = "./.project";
		try {
			FileInputStream input = new FileInputStream(src);
			int readData = -1;
			while ((readData = input.read())!=-1) {
				System.out.print((char)readData);
			}
		} catch (FileNotFoundException e) {
			System.out.println("���� ������ �����ϴ�.");
		}catch (IOException e) {
			System.out.println("�����б� ����");
		}
		System.out.println("�����б� �Ϸ�");
	}
}
class TryCatchFinallyFlow{
	public void name() {
		int num = new Random().nextInt(2);
		try {
			System.out.println("code 1 , num:"+num);
			int i = 1/num;
			System.out.println("code 2 - ���ܾ���");
			return;  ///////////////////////////////////
		} catch (ArithmeticException e) {
			System.out.println("code 3 - ����ó�� �Ϸ�");
		}finally {
			System.out.println("code 4 - ������ ����");
		}
		System.out.println("code 5");
	}
}



public class BigException {

	public static void main(String[] args) {
		
//			SimpleException simple = new SimpleException();
//			simple.name();
//		System.out.println("------------------------------");
//			TryCatchFlow tcf = new TryCatchFlow();
//			tcf.name();
//		System.out.println("------------------------------");
//			MultiExceptionHandling meh = new MultiExceptionHandling();
//			meh.name();
//		System.out.println("------------------------------");
//			HierarchyException he = new HierarchyException();
//			he.name();
//		System.out.println("------------------------------");		
			TryCatchFinallyFlow tcff = new TryCatchFinallyFlow();
			tcff.name();
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		
		
		
		
		
		
		
		
		
		
		
		
			
	}

}
