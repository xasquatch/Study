package Chapter14;

public class YieldTest {

	static class YieldThread extends Thread {
		String symbol;

		public YieldThread(String symbol) {
			this.symbol = symbol;
		}

		@Override
		public void run() {
			for (int i = 0; i < 60; i++) {

				if (i % 2 == 0) {
					System.out.println("symbol");
				} else {
					Thread.yield();
				}

			}
		}

	}

	public static void main(String[] args) {
		new YieldThread("_").start();
		new YieldThread("^").start();
	}

}
