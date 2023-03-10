package com.fdm.aop.service;

import com.fdm.aop.model.Circle;
import com.fdm.aop.model.Triangle;

public class FactoryService {
	
	public Object getbean(String beantype) {
		if (beantype.equals("shapeService")) {
			return new ShapeService();
		}
		if (beantype.equals("circle")) {
			return new Circle();
		}
		if (beantype.equals("triangle")) {
			return new Triangle();
		}
		return null;
	}

}
