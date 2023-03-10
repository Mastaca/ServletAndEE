package com.fdm.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdm.aop.service.ShapeService;

public class AopMain {
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = applicationContext.getBean("shapeService", ShapeService.class);
		shapeService.getCircle().setName("Dummy name");
		System.out.println(shapeService.getCircle().getName());
		System.out.println(shapeService.getTriangle().getName());
		
	}

}
