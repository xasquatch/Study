package com.willtoto.dto;

import java.sql.Timestamp;

public class Point_game1DTO {
	private int num;
	private String game_id;
	private String game_time;
	
	public Point_game1DTO(int num, String game_id, String game_time) {
		this.num = num;
		this.game_id = game_id;
		this.game_time = game_time;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getGame_id() {
		return game_id;
	}

	public void setGame_id(String game_id) {
		this.game_id = game_id;
	}

	public String getGame_time() {
		return game_time;
	}

	public void setGame_time(String game_time) {
		this.game_time = game_time;
	}
	
	
}
