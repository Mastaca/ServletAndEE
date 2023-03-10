package com.fdm.JavaBrains01_SpringDemo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main( String[] args ) {

		AbstractApplicationContext abstractApplicationContext= new ClassPathXmlApplicationContext("spring.xml");
		abstractApplicationContext.registerShutdownHook();

		Shape shape = (Shape)abstractApplicationContext.getBean("circle"); 
		shape.draw();
		((ClassPathXmlApplicationContext)abstractApplicationContext).close();
		
	}

}
