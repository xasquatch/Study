package Chapter14;

class t2Thread extends Thread {

	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			System.out.printf("2×%d=%d\n", i, 2 * i);
		}
		System.out.println(this.getName() + "종료");
	}

}

class t3Thread extends Thread {

	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			System.out.printf("3×%d=%d\n", i, 3 * i);
		}
		System.out.println(this.getName() + "종료");
	}

}

class t4Thread extends Thread {

	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			System.out.printf("4×%d=%d\n", i, 4 * i);
		}
		System.out.println(this.getName() + "종료");
	}

}

class t5Thread extends Thread {

	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			System.out.printf("5×%d=%d\n", i, 5 * i);
		}
		System.out.println(this.getName() + "종료");
	}

}

public class TestThread {

	public static void main(String[] args) {
		t2Thread t2 = new t2Thread();
		t3Thread t3 = new t3Thread();
		t4Thread t4 = new t4Thread();
		t5Thread t5 = new t5Thread();
		t2.setPriority(5);
		t3.setPriority(6);
		t4.setPriority(7);
		t5.setPriority(8);
		t2.start();
		t3.start();
		t4.start();
		t5.start();
//		
//		Thread f1 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				for (int i = 1; i < 10; i++) {
//					System.out.printf("2×%d=%d",i,i*2);
//				}
//				
//			}
//		});
//	
//		f1.setPriority(5);
//		f1.start();

	}

}
