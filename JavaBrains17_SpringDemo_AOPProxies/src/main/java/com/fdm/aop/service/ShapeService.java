package com.fdm.aop.service;

import com.fdm.aop.model.Circle;
import com.fdm.aop.model.Triangle;

public class ShapeService {
	
	private Circle circle;
	private Triangle triangle;
	
//	@Loggable
	public Circle getCircle() {
		System.out.println("Circle getter called");
		return circle;
	}
	
	public void setCircle(Circle circle) {
		this.circle = circle;
	}	
	
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
	
	

}
