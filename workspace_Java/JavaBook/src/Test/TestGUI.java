package Test;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class TestGUI extends JFrame{

	
	
	
	
	public TestGUI() throws HeadlessException {
		
		setTitle("Jframe");
		setSize(300, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		TestGUI gu = new TestGUI();

	}

}
