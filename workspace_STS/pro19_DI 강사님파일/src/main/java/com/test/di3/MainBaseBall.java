package com.test.di3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainBaseBall {
	public static void main(String[] args) {
	//원래 설정 파일은 .xml파일 이었는데...
	//우리는 ConfigApp.java파일에 자바코드! 즉!  메소드를 이용하여
	//<bean>태그들이 설정 되어 있다.
	//ConfigApp.java파일에 설정 되어 있는 <bean>코드를 
	//스프링컨테이너가 분석해서 각각의 bean객체들을 생성해서 보관 해야한다
	//방법 : AnnotationConfigApplicationContext 스프링 컨테이너
	//객체를 이용하여  ConfigApp.java 파일을 분석!
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





