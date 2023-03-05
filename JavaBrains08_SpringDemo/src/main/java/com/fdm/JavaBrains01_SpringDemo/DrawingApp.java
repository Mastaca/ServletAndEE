package com.fdm.JavaBrains01_SpringDemo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
	
    public static void main( String[] args ) {
    	
    	AbstractApplicationContext abstractApplicationContext= new ClassPathXmlApplicationContext("spring.xml");
    	abstractApplicationContext.registerShutdownHook();
    	Triangle triangle = (Triangle)abstractApplicationContext.getBean("triangle");
    	triangle.draw();
    	((ClassPathXmlApplicationContext)abstractApplicationContext).close();
    }
    
}
