package com.test.di3;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration  : �����������ӿ�ũ��  �����̳ʸ� ����Ͽ� 
					//���� ���� �ϱ� ���� ���� �������� �˸�

//Ŭ���� �տ� @Configuration ������̼� ��ȣ�� �����ϴµ�..
//"��Ŭ������ ������ ������ ���Ǵ� Ŭ������" ���~~ 
//�����Ϸ����� �˷��ִ� ������̼� ��ȣ @Configuration
@Configuration
public class ConfigApp { //<----- .xml�������ϰ� �Ȱ�����
	
	//��ü�� �����ϰ� �ʱ�ȭ �� ��Ÿ���� ������̼� ��ȣ @Bean
	// .xml ���Ͽ��� <bean>�±׸� �޼ҵ�� ����� 
	@Bean
	public Player player1() {
		
		ArrayList<String> position = new ArrayList<String>();
		position.add("4��Ÿ��");
		position.add("3���");
		
		Player player1 = new Player("�ں�ȣ",28,position);
		player1.setHeight(187);
		player1.setWeight(80);
		
		return player1;		
	}
	
	@Bean
	public Player player2() {
		
		ArrayList<String> position = new ArrayList<String>();
		position.add("3��Ÿ��");
		position.add("���ݼ�");
		
		Player player2 = new Player("����ȣ",28,position);
		player2.setHeight(186);
		player2.setWeight(80);
		
		return player2;				
	}

}





