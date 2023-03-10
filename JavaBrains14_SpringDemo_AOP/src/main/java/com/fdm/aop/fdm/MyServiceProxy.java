package com.fdm.aop.fdm;

import com.fdm.aop.aspect.LoggingAspect;

public class MyServiceProxy extends MyService {
	
	public String getText() {
		String text = super.getText();
		new LoggingAspect().secondAdvice();		
		return text;
		
	}

}
