package com.test.di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Testmain {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:test.xml");
		TestDao dao = ctx.getBean("TestDaoimpl",TestDaoimpl.class);
		System.out.println("===================================================");
		dao.printMsg();
		System.out.println("===================================================");
		
		
	}

}
