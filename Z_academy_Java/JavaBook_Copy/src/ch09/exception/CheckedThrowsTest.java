package ch09.exception;

public class CheckedThrowsTest {
	public static void main(String[] args) {
		CheckedThrowsTest et = new CheckedThrowsTest();
		try {
			et.method1();
		} catch (ClassNotFoundException e) {
			System.out.printf("����ó�� : %s%n",e.getMessage());
		}
		System.out.println("���α׷� ����");
	}

	public void method1() throws ClassNotFoundException{
		method2();
	}

	public void method2() throws ClassNotFoundException{
		Class.forName("some class");
	}
}
