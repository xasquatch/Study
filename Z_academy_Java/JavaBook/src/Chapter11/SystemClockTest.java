package Chapter11;

public class SystemClockTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.nanoTime();
		int num = 20;
		long result = getFactorial(num);
		System.out.printf("%d   %d%n",num,result);
		long end = System.nanoTime();
		System.out.println(end-start);
	}

	private static long getFactorial(int num) {
		if (num == 1) {
			return num;
		}else {
			return num * getFactorial(num-1);
			
		}
	}

}
