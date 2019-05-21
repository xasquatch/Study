package Chapter16;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Exam2 extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	public Exam2() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel apple = new JLabel("apple");
		panel.add(apple);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(5);
		
		JLabel cherry = new JLabel("cherry");
		panel.add(cherry);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(5);
		
		JLabel strawberry = new JLabel("strawberry");
		panel.add(strawberry);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(5);
		
		JLabel prune = new JLabel("prune");
		panel.add(prune);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(5);
		
		
		
		setSize(1000, 500);
		setVisible(true);
	}
		
		
	
	public static void main(String[] args) {
		
		new Exam2();
	}

}
