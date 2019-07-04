package com.test.aop;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Mainaop {

	public static void main(String[] args) {
		
		AbstractApplicationContext cxt = new GenericXmlApplicationContext("classpath:aopEx1.xml");
		Student student = cxt.getBean("student" , Student.class);
		student.getinfo();
		
		Staff staff= cxt.getBean("staff" , Staff.class);
		staff.getinfo();
		
		cxt.close();
	}
}
