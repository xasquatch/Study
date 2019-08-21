package com.spring.ex02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest2 {

	public static void main(String[] args) {

		BeanFactory bean = new XmlBeanFactory(new FileSystemResource("person.xml"));

		PersonService service1 = (PersonService) bean.getBean("personService1");

		service1.sayhello();

		System.out.println("=============================");

		PersonService service2 = (PersonService) bean.getBean("personService2");

		service2.sayhello();

	}

}
