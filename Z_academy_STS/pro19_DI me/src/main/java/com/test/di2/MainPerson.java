package com.test.di2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainPerson {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:person.xml");
		PersonInfo personInfo = ctx.getBean("personInfo",PersonInfo.class);
		personInfo.getPersonInfo();

		System.out.println("=========================================");
		
		Person person = ctx.getBean("person2",Person.class);
		personInfo.setPerson(person);
		personInfo.getPersonInfo();
		
		
	}
}
