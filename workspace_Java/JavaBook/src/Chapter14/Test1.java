package Chapter14;

class R1 implements Runnable {

	@Override
	public void run() {

		int result = 0;
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				result = i * j;
				System.out.printf("%d��%d=%d\t", i, j, result);
			}
			System.out.println();
		}
	}

}

class T2 extends Thread{

	@Override
	public void run() {

		int result = 0;
		for (int i = 10; i <= 19; i++) {
			for (int j = 10; j <= 19; j++) {
				result = i * j;
				System.out.printf("%d��%d=%d\t", i, j, result);
			}
			System.out.println();
		}
	}	
	
}


public class Test1 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new R1());
		t1.start();
		System.out.println("���γ���");

		T2 t2 = new T2();
		t2.start();
		
	}

}
