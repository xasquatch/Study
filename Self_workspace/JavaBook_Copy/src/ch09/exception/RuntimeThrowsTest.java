package ch09.exception;

public class RuntimeThrowsTest {
	public static void main(String[] args) {
		RuntimeThrowsTest et = new RuntimeThrowsTest();
		try {
			et.method1();
		} catch (ArithmeticException e) {
			System.out.printf("예외처리 : %s%n",e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
	}

	public void method1(){
		method2();
	}

	public void method2(){
		int i = 1/0;
	}
}
