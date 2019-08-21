package com.test.di5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainBaseball {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigApp.class);
				
		Player player = ctx.getBean("player3", Player.class);
		
		System.out.println("�̸�"+player.getName());
		System.out.println("����"+player.getAge());
		System.out.println("������"+player.getPosition());
		System.out.println("����"+player.getHeight());
		System.out.println("������"+player.getWeight());
		
		
		
		
		
		
	}
	
}
