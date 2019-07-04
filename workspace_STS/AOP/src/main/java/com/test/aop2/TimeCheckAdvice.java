package com.test.aop2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class TimeCheckAdvice {
	
	public Object check(ProceedingJoinPoint joinpoint) throws Throwable{
		
		System.out.println("===================================================");
		System.out.println("method start");
		
// ┌ proceed메소드를 호출하지 않으면 비즈니스 로직 수행불가↓
/* │ */	Object returnvalue = joinpoint.proceed();
/* │ */		System.out.println("method end");
/* │ */		System.out.println("===================================================");
/* │ */		
// └ 그 객체 리턴↓
		return returnvalue;
	}
	
}
