package Test;

import java.awt.HeadlessException;

import javax.swing.JFrame;

class Test1 extends JFrame{

	public Test1() {
		setTitle("Thread Test");
		setSize(600,600);
		setVisible(true);
	}
	
	
}

public class Test {

	public static void main(String[] args) {
		Test1 t1 = new Test1();
		
		System.out.println("���� ����");
		
	}

}