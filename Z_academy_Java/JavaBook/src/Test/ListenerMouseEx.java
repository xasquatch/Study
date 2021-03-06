package Test;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ListenerMouseEx extends JFrame {

	ListenerMouseEx() {
		setTitle("악마의 속삭임");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		JButton btn = new JButton("집에 가고 싶습니까?");
		Container text = new JTextField();
		btn.setBackground(Color.YELLOW);
		
		MyMouseListener listener = new MyMouseListener();
		
		btn.addMouseListener(listener);
		add(btn);
		add(text);
		setSize(300,150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ListenerMouseEx();
	}
}
class MyMouseListener implements MouseListener {
	public void mouseEntered(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		btn.setBackground(Color.RED);
	}
	public void mouseExited(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		btn.setBackground(Color.YELLOW);
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		
	}
}