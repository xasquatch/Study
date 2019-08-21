package Chapter16;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exam extends JFrame {

	Container contentPane;
	
	Exam(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		MyPanel panel = new MyPanel();
		contentPane.add(panel,BorderLayout.CENTER);
		
		setSize(500,500);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.black);
			g.drawOval(10, 10, 400, 400);
			g.setColor(Color.RED);
			g.fillArc(10, 10, 400, 400, 90, 120);
			g.setColor(Color.GREEN);
			g.fillArc(10, 10, 400, 400, 330, 120);
			g.setColor(Color.BLUE);
			g.fillArc(10, 10, 400, 400, 210, 120);
		}
		
	}
	
	
	public static void main(String[] args) {

		new Exam();

	}

}
