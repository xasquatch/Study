package Test;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;
public class TestGUI2 extends JFrame {
	TestGUI2() {
		setTitle("�Ǹ��� �ӻ���"); // �������� Ÿ��Ʋ �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane(); 
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setLayout(new FlowLayout()); 
		contentPane.add(new JButton("���� ���� �ͽ��ϱ�?")); 
		Container i = (Container) contentPane.add(new JButton("��")); 
		contentPane.add(new JButton("�׷��� �ؾ��� ���ġ��")); 

		setSize(300, 150); // ������ ũ�� 300x150 ����
		setVisible(true); // �������� ȭ�鿡 ���
		}
		
	public static void main(String[] args) {
		new TestGUI2();
		while (true) System.out.println("���� ����ʹ�");
	}
}