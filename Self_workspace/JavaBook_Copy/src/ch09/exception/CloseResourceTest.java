package ch09.exception;

import java.io.FileInputStream;
import java.io.IOException;

public class CloseResourceTest {

	public static void main(String[] args) {
		CloseResourceTest crt = new CloseResourceTest();
		System.out.println("�ִ� ������ ���");
		crt.useStreamOldStyle(".project");
		System.out.println("���� ���");
		crt.useStreamOldStyle("abc.txt");
	}

	public void useStreamOldStyle(String file) {
		FileInputStream fileinput = null;
		try {
			fileinput = new FileInputStream(file);
			System.out.println("fileinputStream�� �����Ǿ����ϴ�");
			fileinput.read();
		} catch (IOException e) {
			System.out.println("���� ó�� ����");
		}finally {
			System.out.println("finally �� ����");
			if (fileinput != null) {
				try {
					fileinput.close();
					System.out.println("fileinputStream�� �����");
				} catch (IOException e) {
					System.out.println("Fileinputstream ���� ����");
				}
			}
		}
		
	}

}
