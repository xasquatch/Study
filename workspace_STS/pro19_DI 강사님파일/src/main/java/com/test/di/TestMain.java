package com.test.di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 GenericXmlApplicationContext Ŭ����(������ �����̳ʿ���)
 1. ����������? test.xml���Ͽ� ���ǵ� <bean>�±׿� ���� ���� ������ �о��
    bean�±׿� ���� ��ü�� �����ϰ�,
 2. ������ <bean>�±׿� ���� ��ü�� ���������� ���� �Ѵ�.
*/
public class TestMain { //TestMain��  TestDAOImpl�� �����Ѵ�.
	public static void main(String[] args) {
		//�����ϴ� ��ü�� ���� �ؾ���.
//�������� �����ڰ� ���� �����ϴ� ��ü�� ����!  ���� ����!!
//		TestDAOImpl testDAOImpl = new TestDAOImpl();
		
	//GenericXmlApplicationContextŬ������ �����ڷ� ������ 
	//"classpath:test.xml"���� ��θ� �Ű������� ���� �ϸ�..
	//test.xml���������� �̿��Ͽ� bean�±׿� ���� ��ü�� �ڵ����� �����Ͽ�
	//�����ϴ� ������ �����̳ʸ� ���� �ϰ� ��
	AbstractApplicationContext	ctx = 
			new GenericXmlApplicationContext("classpath:test.xml");
//���� TestMainŬ���� ���ο� TestDAOImpl��ü ���������ϱ�
	//-> text.xml���������� �̿��Ͽ� ������ �����̳��� getBean()�޼ҵ带 ����
	//TestDAOImpl��ü(��)�� ���ͼ�
	//TestDao�������̽� Ÿ���� ���������� �ڽİ�ü��? TestDAOImpl��ü(��)����
	TestDao testDao = ctx.getBean("TestDAOImp",TestDAOImpl.class);
		
	System.out.println("====================");
	//���� TestMainŬ�����ȿ� TestDAOImpl��ü�� �������� �Ǿ����Ƿ�..
	//TestDAO testDao = new TestDAOImpl();�ڵ带 ������� �ʾ������� �ұ��ϰ�
	//TestDAOImpl��ü�� printMsg()�޼ҵ带 �ٷ� ȣ���ؼ� ����Ҽ� �ִ�.
	testDao.printMsg();
	System.out.println("====================");
	
	}

}




