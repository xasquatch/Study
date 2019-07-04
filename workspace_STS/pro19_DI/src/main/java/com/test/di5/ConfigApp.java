package com.test.di5;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

// @Configuration  : �����������ӿ�ũ��  �����̳ʸ� ����Ͽ� 
					//���� ���� �ϱ� ���� ���� �������� �˸�

//Ŭ���� �տ� @Configuration ������̼� ��ȣ�� �����ϴµ�..
//"��Ŭ������ ������ ������ ���Ǵ� Ŭ������" ���~~ 
//�����Ϸ����� �˷��ִ� ������̼� ��ȣ @Configuration

@ImportResource("classpath:baseBall2.xml")
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
	
	

}





