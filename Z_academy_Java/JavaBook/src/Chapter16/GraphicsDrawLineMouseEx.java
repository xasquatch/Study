package Chapter16;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawLineMouseEx extends JFrame {

	Container ContentPane;
	GraphicsDrawLineMouseEx(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("드로잉 라인 마우스 예제");
		ContentPane = getContentPane();
		MyPanel panel = new MyPanel();
		ContentPane.add(panel, BorderLayout.CENTER);
		setSize(500,500);
		setVisible(true);
		
	}
	
	class MyPanel extends JPanel{
		Vector<Point> vs = new Vector<Point>();
		Vector<Point> ve = new Vector<Point>();
		
		Point startP = null;
		Point endP = null;
		
		public MyPanel() {
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					startP = e.getPoint();
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					endP = e.getPoint();
					vs.add(startP);
					ve.add(endP);
					repaint();
				}
				
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
				for (int i = 0; i < vs.size(); i++) {
					Point s = vs.elementAt(i);
					Point e = ve.elementAt(i);
					g.drawLine((int)s.getX(), (int)s.getY(), (int)e.getX(), (int)e.getY());
				}
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		new GraphicsDrawLineMouseEx();

	}

}
