package com.test.di2;

//사람에 대한 정보를 출력해주는 클래스 
public class PersonInfo {// PersonInfo클래스 -> person클래스를 의존함.
	
	//Person객체를 저장할 참조변수 선언
	private Person person; //객체를 주입 해야함 -_-
	
	//생성자를 통한 Person객체를 위의 변수에 주입 해야 하므로..
	//생성자 하나 만들기
	public PersonInfo(Person person) {
		this.person = person;
	}
	//기본생성자 : 아무일도 하지 않음
	public PersonInfo() {}

	//Person객체에 대한 정보를 출력해주는 메소드
	public void getPersonInfo() {
		//조건 : Person객체가 위의 참조변수에 저장되어 있으면?
		if(person != null) {
			System.out.println("이름 : " + person.getName());
			System.out.println("성별 : " + person.getGender());
			System.out.println("나이 : " + person.getAge());
			System.out.println("주민번호 : " + person.getIdNo());
			System.out.println("-----------------------------");
		}
	}
	//Person객체를 매개변수로 전달받아.. 위의 person변수에 저장할 메소드 
	public void setPerson(Person person) {
		this.person = person;
	}
	
}




