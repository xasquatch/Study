package Chapter14;

import java.util.Scanner;

public class StopTest {

	static class ResourceUseThread extends Thread {
		boolean flag = true;

		@Override
		public void run() {
			System.out.println("�ڿ�ȹ��");
			while (flag) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("�ڿ����");
			}
			System.out.println("�ڿ��ݳ�");
		}

	}

	public static void main(String[] args) {
		ResourceUseThread t = new ResourceUseThread();
		t.start();
		
		Scanner sc = new Scanner(System.in);
		if (sc.nextLine().equals("s")) {
			t.stop();
		}else {
			t.flag = false;
		}
		sc.close();
		System.out.println("main Over");
		
	}

}
