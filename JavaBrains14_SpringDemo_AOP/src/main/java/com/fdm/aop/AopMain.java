package com.fdm.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdm.aop.aspect.LoggingAspect;
import com.fdm.aop.fdm.MyService;
import com.fdm.aop.service.ShapeService;

public class AopMain {
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = applicationContext.getBean("shapeService", ShapeService.class);
		MyService myService = (MyService)applicationContext.getBean("fdm");
		System.out.println(myService.getText());
		MyService myService2 = new MyService() {
			public String getText() {
				new LoggingAspect().secondAdvice();
				return super.getText();						
			}
		};
		System.out.println(myService2.getText());
//		System.out.println(shapeService.getCircle().getName());
//		System.out.println(shapeService.getTriangle().getName());
		
	}

}
