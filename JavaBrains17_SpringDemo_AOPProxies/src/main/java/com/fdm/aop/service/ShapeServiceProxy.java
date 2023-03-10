package com.fdm.aop.service;

import com.fdm.aop.aspect.LoggingAspect;
import com.fdm.aop.model.Circle;

public class ShapeServiceProxy extends ShapeService {
	
	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
		
	}
	
}
