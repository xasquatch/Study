package ch09.exception;

import java.io.FileInputStream;
import java.io.IOException;

public class CloseResourceTest {

	public static void main(String[] args) {
		CloseResourceTest crt = new CloseResourceTest();
		System.out.println("있는 파일인 경우");
		crt.useStreamOldStyle(".project");
		System.out.println("없는 경우");
		crt.useStreamOldStyle("abc.txt");
	}

	public void useStreamOldStyle(String file) {
		FileInputStream fileinput = null;
		try {
			fileinput = new FileInputStream(file);
			System.out.println("fileinputStream이 생성되었습니다");
			fileinput.read();
		} catch (IOException e) {
			System.out.println("파일 처리 실패");
		}finally {
			System.out.println("finally 블럭 동작");
			if (fileinput != null) {
				try {
					fileinput.close();
					System.out.println("fileinputStream이 종료됨");
				} catch (IOException e) {
					System.out.println("Fileinputstream 종료 실패");
				}
			}
		}
		
	}

}
