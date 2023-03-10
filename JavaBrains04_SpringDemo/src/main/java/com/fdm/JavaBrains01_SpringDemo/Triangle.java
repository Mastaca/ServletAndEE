package com.fdm.JavaBrains01_SpringDemo;

import java.util.List;

public class Triangle {
	
	private List<Point> points;
	
	private Point pointA;
	private Point pointB;
	private Point pointC;		
	
	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
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
		for (Point point : points) {
			System.out.println("Pont A = (" + point.getX() + ", " + point.getY() + ")");
		}
	}

}
