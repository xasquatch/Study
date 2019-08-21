package sec02.ex02;

import java.sql.Date;

public class MemberVO { //오라클의 t_member테이블 이용
	
	
	private String id, pwd, name, email;
	private Date joinDate;
	
	
	public MemberVO(String id, String pwd, String name, String email) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}

	public MemberVO() {
		System.out.println("MemberVo 기본생성자 호출");
	}

	public MemberVO(String id, 
					String pwd, 
					String name, 
					String email, 
					Date joinDate) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.joinDate = joinDate;
		
	}
	//getter,setter메소드 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}
