package com.fdm.JavaBrains01_SpringDemo;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//import org.springframework.beans.factory.annotation.Required;

@Component(value = "circle")
public class Circle implements Shape{

	private Point center;
	
	public void draw() {
		System.out.println("Drawing Circle");
		System.out.println("Circle: Point is: (" + center.getX() + ", " + center.getY()+")" );
	}

	public Point getCenter() {
		return center;
	}
	
//	@Required
//	@Autowired
//	@Qualifier("circleRelated")
//	@Resource(name = "pointC") this doesn't exist in this version
	public void setCenter(Point point) {
		this.center = point;
	}
	
//	@PostConstruct -this doesn't exist in this version
	public void initializeCircle() {
		System.out.println("Init of Circle");
	}
	
//	@PreDestroy -this doesn't exist in this version
	public void destroyCircle() {
		System.out.println("Destroy of Circle");
	}

}
