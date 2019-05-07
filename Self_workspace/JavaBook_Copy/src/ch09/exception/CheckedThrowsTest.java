package ch09.exception;

public class CheckedThrowsTest {
	public static void main(String[] args) {
		CheckedThrowsTest et = new CheckedThrowsTest();
		try {
			et.method1();
		} catch (ClassNotFoundException e) {
			System.out.printf("예외처리 : %s%n",e.getMessage());
		}
		System.out.println("프로그램 종료");
	}

	public void method1() throws ClassNotFoundException{
		method2();
	}

	public void method2() throws ClassNotFoundException{
		Class.forName("some class");
	}
}
