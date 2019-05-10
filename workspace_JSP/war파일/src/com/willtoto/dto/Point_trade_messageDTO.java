package com.willtoto.dto;

public class Point_trade_messageDTO {
	private String id;
	private String message;
	private String message_time;
	
	
	public Point_trade_messageDTO(String id, String message, String message_time) {
		this.id = id;
		this.message = message;
		this.message_time = message_time;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage_time() {
		return message_time;
	}
	public void setMessage_time(String message_time) {
		this.message_time = message_time;
	}
	
	
}
