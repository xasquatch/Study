package Chapter14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoinTest {

	static class GuguThread extends Thread{
		private int dan;
		String[] result = new String[9];
		
		public GuguThread(int dan) {
			this.dan = dan;
		}

		@Override
		public void run() {
			for (int i = 1; i < 10; i++) {
				result[i-1] = dan+"*"+i+"="+(dan*i);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(dan + "�� �Ϸ�");
		}
	}
	
	public static void main(String[] args) {
		List<GuguThread> gugus = new ArrayList();
		
		for (int i = 1; i < 10; i++) {
			GuguThread gugu = new GuguThread(i);
			gugus.add(gugu);
			gugu.start();
		}
		
		for (GuguThread gugu : gugus) {
			try {
//				if (gugu.dan == 7) {
					gugu.join();
//				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n������ ���");
		for (GuguThread gugu : gugus) {
			System.out.println(Arrays.toString(gugu.result));
		}
	}

}