package com.test.aop2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class AppMain {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext cxt = new FileSystemXmlApplicationContext("/src/main/resources/aopEx2.xml");
		
		Service serviceImpl = (Service) cxt.getBean("service");
		
		serviceImpl.addBoard();
		
		cxt.destroy();
		cxt.close();
		
		
	} 
	
}
