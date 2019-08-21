package Test;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;
public class TestGUI2 extends JFrame {
	TestGUI2() {
		setTitle("악마의 속삭임"); // 프레임의 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane(); 
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setLayout(new FlowLayout()); 
		contentPane.add(new JButton("집에 가고 싶습니까?")); 
		Container i = (Container) contentPane.add(new JButton("네")); 
		contentPane.add(new JButton("그래도 해야죠 양아치야")); 

		setSize(300, 150); // 프레임 크기 300x150 설정
		setVisible(true); // 프레임을 화면에 출력
		}
		
	public static void main(String[] args) {
		new TestGUI2();
		while (true) System.out.println("집에 가고싶다");
	}
}