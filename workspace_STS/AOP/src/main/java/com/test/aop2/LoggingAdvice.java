package com.test.aop2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class LoggingAdvice {
	
	public void logging(JoinPoint joinpoint) {
			
		Signature method = joinpoint.getSignature();
			
		String methodname = method.getName();
		
		System.out.println("methodName : "+methodname);
	}
	
}
