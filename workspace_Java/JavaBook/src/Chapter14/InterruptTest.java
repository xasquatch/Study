package Chapter14;

public class InterruptTest {

	static class MinuteAlarmThread extends Thread{

		@Override
		public void run() {
			try {
				Thread.sleep(1000*60);
			} catch (InterruptedException e) {
				System.out.println("¿∏æ«");
			}
			System.out.println("Ω√∞£¿Ã ¥Ÿµ ");
		}
		
	}
	public static void main(String[] args) {
		Thread timeChecker = new MinuteAlarmThread();
		timeChecker.start();

		try {
//			timeChecker.sleep(1000*10);
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		timeChecker.interrupt();
	}

}
