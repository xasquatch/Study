package com.bean.board;

import java.sql.Timestamp;

//jspbeginner데이터베이스 내부에 있는 tblBoard테이블에 레코드를 저장할 DTO클래스
//참고 : tblboard테이블의 필드명과 동일하게 변수명을 지정하자
public class BoardDTO {
	private int num;
	private String name;
	private String email;
	private String homepage;
	private String subject;
	private String content;
	private String pass;
	private int count;
	private String ip;
	private Timestamp regdate;
	private int pos;
	private int depth;

	
	
	public BoardDTO() {}

	public BoardDTO(int num, String name, String email, String homepage, String subject, String content, String pass,
			int count, String ip, Timestamp regdate, int pos, int depth) {
		this.num = num;
		this.name = name;
		this.email = email;
		this.homepage = homepage;
		this.subject = subject;
		this.content = content;
		this.pass = pass;
		this.count = count;
		this.ip = ip;
		this.regdate = regdate;
		this.pos = pos;
		this.depth = depth;
	}
//생성자----------------------------------------------------------------------------------
	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

}
