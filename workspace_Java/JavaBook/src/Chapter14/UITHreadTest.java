package Chapter14;

import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;

public class UITHreadTest {

	public static void main(String[] args) {
		Random rd = new Random();
		int first = rd.nextInt(9)+1;
		int second = rd.nextInt(9)+1;

		
		
		for (int i = 10; i > 0; i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ignore) {}
			
			System.out.println("countdown: "+ i);
			
		}
		
		String result = JOptionPane.showInputDialog(first+"×"+second+"?");
		System.out.println("입력: " + result + ", 정답은 : "+(first*second));
		
	}

}
