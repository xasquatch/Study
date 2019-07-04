package com.test.di5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainBaseBall {
	public static void main(String[] args) {
	
		AnnotationConfigApplicationContext	ctx	=
				 new AnnotationConfigApplicationContext(ConfigApp.class);
		
	
	//getBean()메소드로 스프링컨테이너에 보관되어 있는 Player객체를 리턴해서 받아올떄
	//getBean("메소드이름",리턴클래스타입)을 적어 준다
	Player player1 = ctx.getBean("player1", Player.class);

	System.out.println("선수이름 : " + player1.getName());
	System.out.println("선수나이 : " + player1.getAge());
	System.out.println("선수포지션 : " + player1.getPosition());
	System.out.println("선수신장 : " + player1.getHeight());
	System.out.println("선수몸무게 : " + player1.getWeight());
	
	System.out.println("==================================");
	
	
	Player player2 = ctx.getBean("player2",Player.class);
	
	System.out.println("선수이름 : " + player2.getName());
	System.out.println("선수나이 : " + player2.getAge());
	System.out.println("선수포지션 : " + player2.getPosition());
	System.out.println("선수신장 : " + player2.getHeight());
	System.out.println("선수몸무게 : " + player2.getWeight());	
	
	

	
	}

}





