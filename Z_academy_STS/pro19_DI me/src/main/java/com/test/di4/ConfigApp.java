package com.test.di4;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.di5.Player;

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
