package com.fdm.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.fdm.aop.model.Circle;

@Aspect
public class LoggingAspect {
	
//	@Before("execution(public String com.fdm.aop.model.Circle.getName())")
//	@Before("execution(public * get*())")
//	@Before("execution(* get*())")
//	@Before("execution(* get*(*))")
//	@Before("execution(* get*(..))")
//	@Before("execution(* com.fdm.aop.*.*.get*(..))")
	@Before("allCircleMethods()")
	public void LogginAdvice(JoinPoint joinpoint) {
//		Circle circle = (Circle)joinpoint.getTarget();
		
	}
	
//	@Before("args(String)")
	@Before("args(name)")
	public void stringArgumentMethods(String name) {
		System.out.println("A method that takes String arguments has been called. the value is: " + name);
	}
	
	@Pointcut("execution(* get*())")
	public void allGetters() {}
	
//	@Pointcut("execution(* * com.fdm.aop.model.Circle.*(..))")
//	@Pointcut("within(com.fdm.aop.model.*)")
//	@Pointcut("within(com.fdm.aop.model..*)")
	@Pointcut("within(com.fdm.aop.model.Circle)")
	public void allCircleMethods() {}
	
}
