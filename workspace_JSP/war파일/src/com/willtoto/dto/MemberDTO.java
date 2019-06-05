package com.willtoto.dto;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String e_mail;
	private String pass_q;
	private String pass_a;
	private long point;
	private String join_time;
	
	
	public MemberDTO(String id, String pw, String name, String e_mail, String pass_q, String pass_a, long point, String join_time){
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.e_mail = e_mail;
		this.pass_q = pass_q;
		this.pass_a = pass_a;
		this.point = point;
		this.join_time = join_time;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public String getPass_q() {
		return pass_q;
	}
	public void setPass_q(String pass_q) {
		this.pass_q = pass_q;
	}
	public String getPass_a() {
		return pass_a;
	}
	public void setPass_a(String pass_a) {
		this.pass_a = pass_a;
	}
	public long getPoint() {
		return point;
	}
	public void setPoint(long point) {
		this.point = point;
	}
	public String getJoin_time() {
		return join_time;
	}
	public void setJoin_time(String join_time) {
		this.join_time = join_time;
	}
}
