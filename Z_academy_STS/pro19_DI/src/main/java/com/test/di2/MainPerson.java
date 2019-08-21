package com.test.di2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainPerson {//프로그램의 시작점

	public static void main(String[] args) {
		
	//스프링 컨테이너 역할을 하는 객체 생성
		//생성시..person.xml파일의 bean태그를 읽어들여  
		//bean태그들에 대한 객체를 생성하여 보관
	GenericXmlApplicationContext ctx =
	new GenericXmlApplicationContext("classpath:person.xml");

	//getBean()메소드는 컨테이너가  XML파일을 읽어와 생성한  bean태그에 대한 객체를 
	//검색할떄 사용된다.
	//getBean()메소드의 첫번쨰 파라미터값은 <bean>태그의 id속성으로 지정한 이름이며,
	//                두번쨰 파라미터값은 검색할 객체의 클래스 타입 입니다.
	//결론 : getBean()메소드는 person.xml파일 설정을 통해서 생성되는
	//     PersonInfo객체를 리턴 한다.
	PersonInfo personInfo = 
			ctx.getBean("personInfo",PersonInfo.class);
	
	//person.xml설정파일 보면.. PersonInfo객체 안에 Person객체를 의존주입 해놓았으므로
	//바로위의 스프링 컨테이너에서 얻어온 PersonInfo객체의 getPersonInfo()메소드를 
	//호출하여 Person객체의 각 변수값들을 getter메소드를 이용하여 출력하고 있음
//	이름 : 홍길동
//	성별 : 남
//	나이 : 26
//	주민번호 : 911111-1121111	
	personInfo.getPersonInfo();
		
	Person person2 = ctx.getBean("person2", Person.class);	
	personInfo.setPerson(person2);
	personInfo.getPersonInfo();
//	이름 : 홍길서
//	성별 : 여
//	나이 : 15
//	주민번호 : 941212-2511515
//	-----------------------------
	
	ctx.close(); //스프링 컨테이너 해제 ~ 
	
	}

}


