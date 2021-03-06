package Test;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

class DotLocation extends JFrame{
	
	DotLocation(){
		setTitle("LOCATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		for (int i = 0; i < 20; i++) {
			JLabel label = new JLabel(); 
			Random rd = new Random();
			int x = rd.nextInt(250)+50;
			int y = rd.nextInt(250)+50;
			Color cl = new Color(x-45,y-45,i);
			label.setLocation(x,y);
			label.setSize(10,10);
			label.setOpaque(true);
			label.setBackground(cl);
			add(label);
		}
		
		setSize(300, 300);
		setVisible(true);
	}
}

class ColorJFrame extends JFrame{
	
	ColorJFrame(){
		setTitle("????");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(4, 4));
		Container c = getContentPane();
		
		
		for (int i = 1; i <= 100; i++) {
			Random rd = new Random();
			int j = rd.nextInt(255);
			int k = rd.nextInt(255);
			int l = rd.nextInt(255);
			Color color = new Color(j,k,l);
			JPanel p = new JPanel();
			p.setOpaque(true);
			p.setBackground(color);
			c.add(p);
		}
		
		setSize(500, 500);
		setVisible(true);

	}
}

class NullContainerEx extends JFrame {
		NullContainerEx() {
			setTitle("Null Container Sample");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Container c = getContentPane();
			c.setLayout(null);
			
			JLabel la = new JLabel("Hello, Press Buttons!");
			la.setLocation(130, 50);
			la.setSize(200, 20);
			c.add(la);
	
			for(int i=1; i<=9; i++) {
				JButton b = new JButton(Integer.toString(i));
				b.setLocation(i*15, i*15);
				b.setSize(50, 20);
				c.add(b);
			}
		
		setSize(300, 200);
		setVisible(true);
	}
}
class GridLayoutEx extends JFrame {
	GridLayoutEx() {
		setTitle("GridLayout Sample"); // 프레임의 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		GridLayout grid = new GridLayout(4, 3, 20, 20);
		grid.setVgap(3);
		c.setLayout(grid);
		c.add(new JLabel("집에 가고싶습니까?"));
		c.add(new JTextField("네"));
		c.add(new JButton("그럼누르세요"));
		c.add(new JLabel("동영상"));
		c.add(new JTextField("네"));
		c.add(new JTextField("네"));
		c.add(new JLabel("이미지"));
		c.add(new JTextField("네"));
		c.add(new JTextField("네"));
		c.add(new JLabel("네니뇨"));
		c.add(new JTextField("네"));
		c.add(new JTextField("네"));
		setSize(300, 200);
		setVisible(true);
	}
}
public class BorderLayoutEx extends JFrame {
	BorderLayoutEx() {
		
		setTitle("동서남북");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout(10,20));
		c.add(new JButton("Calculate"), BorderLayout.CENTER);
		c.add(new JButton("add"), BorderLayout.NORTH);
		c.add(new JButton("sub"), BorderLayout.SOUTH);
		c.add(new JButton("mul"), BorderLayout.EAST);
		c.add(new JButton("div"), BorderLayout.WEST);
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new DotLocation();
//		while (true) System.out.println("k");
//		new ColorJFrame();
//		new NullContainerEx();
//		new BorderLayoutEx();
//		new GridLayoutEx();
	}
}