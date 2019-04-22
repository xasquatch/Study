package ch11.system;

public class SystemClockTest {

	public static void main(String[] args) {

		long start = System.nanoTime();
		int num = 20;
		long result = getFactorial(num);
		System.out.println(num+"!��"+result+"�Դϴ�");
		long end = System.nanoTime();
		System.out.println("�� �ҿ�ð�"+(end-start));
		
	}

	private static long getFactorial(int num) {
		long result;
		if(num ==1) {
			result = num;
		}else {
			result = num*getFactorial(num-1);
		}
		return result;
	}
}
