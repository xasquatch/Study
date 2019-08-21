package sec01.ex01;

import java.sql.Date;
//자바빈의 종류 : DTO, DAO 클래스

//회원 정보를 저장하는 MemberBean클래스 만들기
//참고 : DB의 t_member 회원테이블을 참고해 클래스를 작성함.
public class MemberBean { //DTO클래스 역할(VO클래스 역할)
	/*회원 테이블의 컬럼이름과 동일하게 변수 이름과 자료형을 선언합니다.*/
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joindate;
	//private선언 DTO(VO)클래스의 규칙
	
	public MemberBean(){}
	
	/*인자가 4개인 생성자*/
	public MemberBean(String id, String pwd, String name, String email) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}

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

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	
	
	
}
