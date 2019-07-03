package com.test.di3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainBaseBall {
	public static void main(String[] args) {
	//���� ���� ������ .xml���� �̾��µ�...
	//�츮�� ConfigApp.java���Ͽ� �ڹ��ڵ�! ��!  �޼ҵ带 �̿��Ͽ�
	//<bean>�±׵��� ���� �Ǿ� �ִ�.
	//ConfigApp.java���Ͽ� ���� �Ǿ� �ִ� <bean>�ڵ带 
	//�����������̳ʰ� �м��ؼ� ������ bean��ü���� �����ؼ� ���� �ؾ��Ѵ�
	//��� : AnnotationConfigApplicationContext ������ �����̳�
	//��ü�� �̿��Ͽ�  ConfigApp.java ������ �м�!
	AnnotationConfigApplicationContext	ctx	=
			 new AnnotationConfigApplicationContext(ConfigApp.class);
	
	//getBean()�޼ҵ�� �����������̳ʿ� �����Ǿ� �ִ� Player��ü�� �����ؼ� �޾ƿË�
	//getBean("�޼ҵ��̸�",����Ŭ����Ÿ��)�� ���� �ش�
	Player player1 = ctx.getBean("player1", Player.class);

	System.out.println("�����̸� : " + player1.getName());
	System.out.println("�������� : " + player1.getAge());
	System.out.println("���������� : " + player1.getPosition());
	System.out.println("�������� : " + player1.getHeight());
	System.out.println("���������� : " + player1.getWeight());
	
	System.out.println("==================================");
	
	
	Player player2 = ctx.getBean("player2",Player.class);
	
	System.out.println("�����̸� : " + player2.getName());
	System.out.println("�������� : " + player2.getAge());
	System.out.println("���������� : " + player2.getPosition());
	System.out.println("�������� : " + player2.getHeight());
	System.out.println("���������� : " + player2.getWeight());	
	
	}

}





