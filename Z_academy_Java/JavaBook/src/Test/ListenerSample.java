package Test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ListenerSample extends JFrame {
	ListenerSample () {
		setTitle("Action �̺�Ʈ ������ �ۼ�");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("Action");
		MyActionListener listener = new MyActionListener ();
		btn.addActionListener(listener);
		add(btn);
		setSize(500,150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ListenerSample ();
	}
}
class MyActionListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		
		JButton b = (JButton)e.getSource();
		
		if(b.getText().equals("Action")) {
			b.setText("�׼�");
		}else {
			b.setText("Action");
		}
	}
}