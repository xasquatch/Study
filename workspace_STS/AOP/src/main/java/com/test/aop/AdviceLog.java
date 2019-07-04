package com.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdviceLog {

	public Object profile(ProceedingJoinPoint joinpoint) throws Throwable {

		String sinStr = joinpoint.getSignature().toLongString();

		System.out.println(sinStr + "is 시작?");

		long startTime = System.currentTimeMillis();

		try {
			Object obj = joinpoint.proceed();
			return obj;

		}finally {
			
			long endTime = System.currentTimeMillis();
			System.out.println(sinStr + "is 종료");
			System.out.println(sinStr + "경과시간 : "+(endTime-startTime));
			
		}
	}

}
