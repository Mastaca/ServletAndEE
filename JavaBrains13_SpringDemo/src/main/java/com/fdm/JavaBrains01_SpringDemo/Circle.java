package com.fdm.JavaBrains01_SpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

//import org.springframework.beans.factory.annotation.Required;

//@Component(value = "circle")  //for beans
//@Service
//@Repository
@Controller
public class Circle implements Shape,  ApplicationEventPublisherAware {

	private Point center;
	private ApplicationEventPublisher applicationEventPublisher;
	@Autowired
	private MessageSource messageSource;
	
	public void draw() {
		System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default Drawing Message", null));
		System.out.println(this.messageSource.getMessage("drawing.point", new Object[] {center.getX(), center.getY()}, "Default Point Message", null));
		DrawEvent drawEvent = new DrawEvent(this);
		applicationEventPublisher.publishEvent(drawEvent);
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

	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

}
