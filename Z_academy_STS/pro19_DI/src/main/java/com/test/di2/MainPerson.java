package com.test.di2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainPerson {//���α׷��� ������

	public static void main(String[] args) {
		
	//������ �����̳� ������ �ϴ� ��ü ����
		//������..person.xml������ bean�±׸� �о�鿩  
		//bean�±׵鿡 ���� ��ü�� �����Ͽ� ����
	GenericXmlApplicationContext ctx =
	new GenericXmlApplicationContext("classpath:person.xml");

	//getBean()�޼ҵ�� �����̳ʰ�  XML������ �о�� ������  bean�±׿� ���� ��ü�� 
	//�˻��ҋ� ���ȴ�.
	//getBean()�޼ҵ��� ù���� �Ķ���Ͱ��� <bean>�±��� id�Ӽ����� ������ �̸��̸�,
	//                �ι��� �Ķ���Ͱ��� �˻��� ��ü�� Ŭ���� Ÿ�� �Դϴ�.
	//��� : getBean()�޼ҵ�� person.xml���� ������ ���ؼ� �����Ǵ�
	//     PersonInfo��ü�� ���� �Ѵ�.
	PersonInfo personInfo = 
			ctx.getBean("personInfo",PersonInfo.class);
	
	//person.xml�������� ����.. PersonInfo��ü �ȿ� Person��ü�� �������� �س������Ƿ�
	//�ٷ����� ������ �����̳ʿ��� ���� PersonInfo��ü�� getPersonInfo()�޼ҵ带 
	//ȣ���Ͽ� Person��ü�� �� ���������� getter�޼ҵ带 �̿��Ͽ� ����ϰ� ����
//	�̸� : ȫ�浿
//	���� : ��
//	���� : 26
//	�ֹι�ȣ : 911111-1121111	
	personInfo.getPersonInfo();
		
	Person person2 = ctx.getBean("person2", Person.class);	
	personInfo.setPerson(person2);
	personInfo.getPersonInfo();
//	�̸� : ȫ�漭
//	���� : ��
//	���� : 15
//	�ֹι�ȣ : 941212-2511515
//	-----------------------------
	
	ctx.close(); //������ �����̳� ���� ~ 
	
	}

}


