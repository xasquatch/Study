package sec02.ex01;

import java.sql.Date;

//VO(Value Object)역할을 하는 클래스
//VO역할이란?
//DB의 테이블에서 조회한 레코드의 컬럼 값을 
//변수에 저장하거나 변수에 저장된 값들을 VO객체를 생성하여 한번에 DB에 추가(insert)할 역할을 수행

//VO역할을 하는 클래스 생성방법
//테이블에서 조회한 레코드의 컬럼값을 속성(변수)에 저장해야하므로
//컬럼 이름과 동일한 자료형과 일므으로 속성(변수)을 선언하고
//getter/setter메소드를 각각 만들어 줍니다.

public class MemberVO {

	// 변수
	private String id; // 회원 아이디 저장할 변수
	private String pwd; // 회원 비밀번호 저장할 변수
	private String name; // 회원 이름 저장할 변수
	private String email; // 회원 이메일 저장할 변수
	private Date joinDate; // 회원 가입일 날짜정보를 저장할 변수 (util 패키지가 아닌 sql패키지의 Date클래스로 선언)

	// 생성자
	public MemberVO() {
		System.out.println("MemberVO 생성자 호출");
	}

	// getter/setter메소드

	// getter메소드 : 메소드 이름이 get으로 시작하는 메소드
	// setter메소드 : 메소드 이름이 set으로 시작하는 메소드
	// getter역할을 하는 메소드란?
	// private으로 선언된 위 변수의 값을 반환할 목적으로 사용됨.
	// setter역할을 하는 메소드란?
	// private으로 선언된 위 변수값을 새로이 저장(세팅)할 목적으로 사용됨.
	
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
