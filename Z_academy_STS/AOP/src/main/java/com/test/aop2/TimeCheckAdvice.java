package com.test.aop2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class TimeCheckAdvice {
	
	public Object check(ProceedingJoinPoint joinpoint) throws Throwable{
		
		System.out.println("===================================================");
		System.out.println("method start");
		
// �� proceed�޼ҵ带 ȣ������ ������ ����Ͻ� ���� ����Ұ���
/* �� */	Object returnvalue = joinpoint.proceed();
/* �� */		System.out.println("method end");
/* �� */		System.out.println("===================================================");
/* �� */		
// �� �� ��ü ���ϡ�
		return returnvalue;
	}
	
}
