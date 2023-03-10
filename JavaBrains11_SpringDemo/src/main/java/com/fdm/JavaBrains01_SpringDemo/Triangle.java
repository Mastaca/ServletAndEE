package com.fdm.JavaBrains01_SpringDemo;

//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;

public class Triangle { //implements InitializingBean, DisposableBean
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	public Triangle() {
	}

	public Triangle(Point pointA, Point pointB, Point pointC) {
		super();
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public void draw() {
		System.out.println("Drawing Triangle");
		System.out.println("Point A = (" + getPointA().getX() + ", " + getPointA().getY() + ")");
		System.out.println("Point B = (" + getPointB().getX() + ", " + getPointB().getY() + ")");
		System.out.println("Point C = (" + getPointC().getX() + ", " + getPointC().getY() + ")");		
	}
	
	public void myInit() {
		System.out.println("MyInit init method called for Triangle");
	}
	
	public void cleanUp() {
		System.out.println("CleanUp init method called for Triangle");
	}

//	public void afterPropertiesSet() throws Exception {
//		System.out.println("InititializingBeans init method called for Triangle");	
//	}
//
//	public void destroy() throws Exception {
//		System.out.println("DispozableBeans init method called for Triangle");	
//				
//	}

}
