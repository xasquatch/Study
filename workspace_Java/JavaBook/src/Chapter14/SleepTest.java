package Chapter14;

import java.time.LocalTime;

public class SleepTest {

	static class Timer extends Thread {

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("°�� : " + LocalTime.now());
			}

		}

	}

	public static void main(String[] args) {
		Timer tm = new Timer();
		tm.start();
		
		
	}

}