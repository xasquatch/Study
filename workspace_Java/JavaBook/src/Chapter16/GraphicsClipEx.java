package Chapter16;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsClipEx extends JFrame {
	
	Container ContentPane;
	GraphicsClipEx(){
		setTitle("클리핑 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ContentPane = getContentPane();
		MyPanel panel = new MyPanel();
		ContentPane.add(panel,BorderLayout.CENTER);
		setSize(500,500);
		setVisible(true);
		
	}
	
	class MyPanel extends JPanel{
		ImageIcon icon = new ImageIcon("./good.jpg");
		Image img = icon.getImage();
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setClip(0,0,1500,1500);
			g.drawImage(img,0,0, getWidth(), getHeight(), this);
			g.setColor(Color.BLUE);
			g.setFont(new Font("SanSerif",Font.ITALIC, 40));
			g.drawString("go", 10, 150);
		}
	}
	
	
	public static void main(String[] args) {
		new GraphicsClipEx();

	}

}
