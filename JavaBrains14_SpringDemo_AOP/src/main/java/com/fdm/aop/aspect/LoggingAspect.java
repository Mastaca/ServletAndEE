package com.fdm.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
//	@Before("execution(public String com.fdm.aop.model.Circle.getName())")
//	@Before("execution(public * get*())")
//	@Before("execution(* get*())")
//	@Before("execution(* get*(*))")
//	@Before("execution(* get*(..))")
//	@Before("execution(* com.fdm.aop.*.*.get*(..))")
	@Before("allGetters() && allCircleMethods()")
	public void LogginAdvice() {
		System.out.println("Advice run. Get Method called");
	}
	
	@Before("allGetters()")
	public void secondAdvice() {
		System.out.println("Second advice is executed");
	}
	
//	@Assync
//	@Transactional
	
	@Pointcut("execution(* get*())")
	public void allGetters() {}
	
//	@Pointcut("execution(* * com.fdm.aop.model.Circle.*(..))")
//	@Pointcut("within(com.fdm.aop.model.*)")
//	@Pointcut("within(com.fdm.aop.model..*)")
	@Pointcut("within(com.fdm.aop.model.Circle)")
	public void allCircleMethods() {}
	
}
