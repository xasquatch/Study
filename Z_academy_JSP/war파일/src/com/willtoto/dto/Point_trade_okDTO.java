package com.willtoto.dto;

public class Point_trade_okDTO {
	private String myid;
	private String send_id;
	private long send_point;
	private String send_time;
	

	public Point_trade_okDTO(String myid, String send_id, long send_point, String send_time) {
		this.myid = myid;
		this.send_id = send_id;
		this.send_point = send_point;
		this.send_time = send_time;
	}

	public String getMyid() {
		return myid;
	}

	public void setMyid(String myid) {
		this.myid = myid;
	}


	public String getSend_id() {
		return send_id;
	}

	public void setSend_id(String send_id) {
		this.send_id = send_id;
	}

	public long getSend_point() {
		return send_point;
	}

	public void setSend_point(long send_point) {
		this.send_point = send_point;
	}

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}




	
}	