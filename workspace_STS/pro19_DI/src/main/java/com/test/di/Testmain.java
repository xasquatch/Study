package com.test.di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 GenericXmlApplicationContext 클래스(스프링 컨테이너역할)
 1. 설정파일인? test.xml파일에 정의된 <bean>태그에 대한 설정 정보를 읽어와
    bean태그에 대한 객체를 생성하고,
 2. 각각의 <bean>태그에 대한 객체를 내부적으로 보관 한다.
*/
public class TestMain { //TestMain은  TestDAOImpl을 의존한다.
	public static void main(String[] args) {
		//의존하는 객체를 주입 해야함.
//예전에는 개발자가 직접 의존하는 객체를 주입!  좋지 않음!!
//		TestDAOImpl testDAOImpl = new TestDAOImpl();
		
	//GenericXmlApplicationContext클래스의 생성자로 설정한 
	//"classpath:test.xml"파일 경로를 매개변수로 전달 하면..
	//test.xml설정파일을 이용하여 bean태그에 대한 객체를 자동으로 생성하여
	//관리하는 스프링 컨테이너를 생성 하게 됨
	AbstractApplicationContext	ctx = 
			new GenericXmlApplicationContext("classpath:test.xml");
//현재 TestMain클래스 내부에 TestDAOImpl객체 의존주입하기
	//-> text.xml설정파일을 이용하여 생성한 컨테이너의 getBean()메소드를 통해
	//TestDAOImpl객체(빈)를 얻어와서
	//TestDao인터페이스 타입의 참조변수에 자식객체인? TestDAOImpl객체(빈)저장
	TestDao testDao = ctx.getBean("TestDAOImp",TestDAOImpl.class);
		
	System.out.println("====================");
	//현재 TestMain클래스안에 TestDAOImpl객체를 의존주입 되었으므로..
	//TestDAO testDao = new TestDAOImpl();코드를 사용하지 않았음에도 불구하고
	//TestDAOImpl객체의 printMsg()메소드를 바로 호출해서 사용할수 있다.
	testDao.printMsg();
	System.out.println("====================");
	
	}

}




