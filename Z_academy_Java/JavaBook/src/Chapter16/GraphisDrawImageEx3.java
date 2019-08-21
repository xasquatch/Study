package Chapter16;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphisDrawImageEx3 extends JFrame {

	Container contentPane;
	GraphisDrawImageEx3(){
		setTitle("drawImage 사용예제3");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		MyPanel panel = new MyPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		setSize(500,500);
		setVisible(true);
		
	}
	
	class MyPanel extends JPanel{
		ImageIcon imageicon = new ImageIcon("./good.jpg");
		Image img = imageicon.getImage();
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), 0, 0, 1500, 1500, this);
		}
	}
	
	public static void main(String[] args) {
		new GraphisDrawImageEx3();
	}
	
}
