package com.test.di4;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainBaseball {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:baseBall.xml");
		
		Player player = ctx.getBean("player2", Player.class);
		
		System.out.println("�̸�"+player.getName());
		System.out.println("����"+player.getAge());
		System.out.println("������"+player.getPosition());
		System.out.println("����"+player.getHeight());
		System.out.println("������"+player.getWeight());
		
		
		
		
		
		
	}
	
}
