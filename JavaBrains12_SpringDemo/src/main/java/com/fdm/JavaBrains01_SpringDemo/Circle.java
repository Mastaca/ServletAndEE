package com.fdm.JavaBrains01_SpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;

//import org.springframework.beans.factory.annotation.Required;

//@Component(value = "circle")  //for beans
//@Service
//@Repository
@Controller
public class Circle implements Shape{

	private Point center;
	@Autowired
	private MessageSource messageSource;
	
	public void draw() {
		System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default Drawing Message", null));
		System.out.println(this.messageSource.getMessage("drawing.point", new Object[] {center.getX(), center.getY()}, "Default Point Message", null));
//		System.out.println(this.messageSource.getMessage("greeting", null, "Default Greeting", null));
	}

	public Point getCenter() {
		return center;
	}
	
//	@Required
	@Autowired
	@Qualifier("center")
	public void setCenter(Point point) {
		this.center = point;
	}
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

}
