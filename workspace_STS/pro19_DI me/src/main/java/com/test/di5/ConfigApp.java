package com.test.di5;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:baseBall2.xml")
@Configuration
public class ConfigApp {

	@Bean
	public Player player1() {

		ArrayList<String> position = new ArrayList<String>();
		position.add("4��Ÿ��");
		position.add("3���");
		
		Player player = new Player("����ȣ", 28, position);
		player.setHeight(222);
		player.setWeight(100);
		
		return player;
	}

}
