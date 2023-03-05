package com.fdm.JavaBrains01_SpringDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
	
    public static void main( String[] args ) {
    	
    	//Triangle triangle = new Triangle();
    	
    	ApplicationContext applicationContext= new ClassPathXmlApplicationContext("spring.xml");
    	Triangle triangle = (Triangle)applicationContext.getBean("triangle-alias");
    	triangle.draw();
    	((ClassPathXmlApplicationContext) applicationContext).close();
    }
    
}
