package Chapter14;

import java.text.SimpleDateFormat;

public class DaemonThreadTest {

	static class SaveDaemon extends Thread {

		public SaveDaemon() {
			this.setDaemon(true);
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000 * 5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("자동저장함");
			}
		}

	}

	public static void main(String[] args) {
		Thread daemon = new SaveDaemon();
		daemon.start();
		
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(1000);
				System.out.print(new SimpleDateFormat("HH:mm:ss.SSS").format(System.currentTimeMillis()/1000));
				System.out.printf("\t");
				System.out.println("작업중..."+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("main over");
	}

}
