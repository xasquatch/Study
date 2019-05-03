package Chapter14;

public class SimpleThreadTest {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 30; i++) {
					System.out.print("-");
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 30; i++) {
					System.out.print("@");
				}
			}
		});
		
		t1.start();
		t2.start();
		
		
	}
	
}
