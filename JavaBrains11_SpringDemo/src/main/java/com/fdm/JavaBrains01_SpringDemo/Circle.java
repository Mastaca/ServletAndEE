package com.fdm.JavaBrains01_SpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	
	public void draw() {
		System.out.println("Drawing Circle");
		System.out.println("Circle: Point is: (" + center.getX() + ", " + center.getY()+")" );
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

}
