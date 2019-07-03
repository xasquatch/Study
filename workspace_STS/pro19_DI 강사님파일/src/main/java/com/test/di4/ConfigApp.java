package com.test.di4;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration  : 스프링프레임워크중  컨테이너를 사용하여 
					//빈을 생성 하기 위한 설정 파일임을 알림

//클래스 앞에 @Configuration 어노테이션 기호를 선언하는데..
//"이클래스는 스프링 설정에 사용되는 클래스다" 라고~~ 
//컴파일러에게 알려주는 어노테이션 기호 @Configuration
@Configuration
public class ConfigApp { //<----- .xml설정파일과 똑같은놈
	
	//객체를 생성하고 초기화 를 나타내는 어노테이션 기호 @Bean
	// .xml 파일에서 <bean>태그를 메소드로 만들기 
	@Bean
	public Player player1() {
		
		ArrayList<String> position = new ArrayList<String>();
		position.add("4번타자");
		position.add("3루수");
		
		Player player1 = new Player("박병호",28,position);
		player1.setHeight(187);
		player1.setWeight(80);
		
		return player1;		
	}
	
	

}





