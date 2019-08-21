package Chapter16;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import java.awt.CardLayout;
import java.awt.Color;

public class Exam2 extends JFrame {
	private JTextField tF1, tF2, tF3, tF4;
	double per1, per2, per3, per4;
	Container contentpane;
	
	
	public Exam2() {
		setTitle("PI CHART");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentpane = getContentPane();
		contentpane.setLayout(new CardLayout(0, 0));
		MyKeyListener li = new MyKeyListener();
		MyActionListner myAction = new MyActionListner();
		
				
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("apple");
		lblNewLabel.setBounds(27, 8, 31, 15);
		panel_1.add(lblNewLabel);
		
		tF1 = new JTextField();
		tF1.setBounds(70, 5, 61, 21);
		panel_1.add(tF1);
		tF1.setColumns(5);
		
		JLabel lblNewLabel_1 = new JLabel("cherry");
		lblNewLabel_1.setBounds(143, 8, 36, 15);
		panel_1.add(lblNewLabel_1);
		
		tF2 = new JTextField();
		tF2.setBounds(191, 5, 61, 21);
		panel_1.add(tF2);
		tF2.setColumns(5);
		
		JLabel lblNewLabel_2 = new JLabel("strawberry");
		lblNewLabel_2.setBounds(264, 8, 60, 15);
		panel_1.add(lblNewLabel_2);
		
		tF3 = new JTextField();
		tF3.setBounds(336, 5, 61, 21);
		panel_1.add(tF3);
		tF3.setColumns(5);
		
		JLabel lblNewLabel_3 = new JLabel("prune");
		lblNewLabel_3.setBounds(409, 8, 32, 15);
		panel_1.add(lblNewLabel_3);
		
		tF4 = new JTextField();
		tF4.setBounds(453, 5, 61, 21);
		panel_1.add(tF4);
		tF4.setColumns(5);
		
		JLabel label = new JLabel("apple");
		label.setForeground(Color.RED);
		label.setBounds(27, 33, 31, 15);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("cherry");
		label_1.setForeground(Color.ORANGE);
		label_1.setBounds(143, 33, 36, 15);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("strawberry");
		label_2.setForeground(Color.MAGENTA);
		label_2.setBounds(264, 33, 60, 15);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("prune");
		label_3.setForeground(Color.BLUE);
		label_3.setBounds(409, 33, 32, 15);
		panel_1.add(label_3);
		getContentPane().add(panel, "name_259246341973201");
		
		setSize(569	, 476);
		setVisible(true);
		
		
	}
	class MyActionListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int num1 = Integer.parseInt(tF1.getText().toString());
			int num2 = Integer.parseInt(tF2.getText().toString());
			int num3 = Integer.parseInt(tF3.getText().toString());
			int num4 = Integer.parseInt(tF4.getText().toString());
			int sum = (num1 + num2 + num3 + num4);
			double per1 = num1/sum*100;
			double per2 = num2/sum*100;
			double per3 = num3/sum*100;
			double per4 = num4/sum*100;
			
			getContentPane().repaint();
			
		}
	}
	class MyPanel extends JPanel{

		@Override
		protected void printComponent(Graphics g) {
			super.printComponent(g);
			g.drawString("사과"+per1+"%", 100, 100);
			g.drawString("체리"+per2+"%", 100, 100);
			g.drawString("딸기"+per3+"%", 100, 100);
			g.drawString("자두"+per4+"%", 100, 100);
		}
	}
	
	
	class MyKeyListener extends KeyAdapter{

		@Override
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			if (!Character.isDigit(c)) {
				e.consume();
				return;
			}
		}
	}
	public static void main(String[] args) {
		new Exam2();
	}
}
