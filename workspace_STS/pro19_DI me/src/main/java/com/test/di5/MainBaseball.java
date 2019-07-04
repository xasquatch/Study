package com.test.di5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainBaseball {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigApp.class);
				
		Player player = ctx.getBean("player3", Player.class);
		
		System.out.println("이름"+player.getName());
		System.out.println("나이"+player.getAge());
		System.out.println("포지션"+player.getPosition());
		System.out.println("신장"+player.getHeight());
		System.out.println("몸무게"+player.getWeight());
		
		
		
		
		
		
	}
	
}
