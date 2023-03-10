package com.fdm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
	
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		
		int i = Integer.parseInt(httpServletRequest.getParameter("t1"));
		int j = Integer.parseInt(httpServletRequest.getParameter("t2"));
		int k = i + j;
		
		ModelAndView modelAndView =  new ModelAndView();
		
		modelAndView.setViewName("display.jsp");
		modelAndView.addObject("result", k);
		
		return modelAndView;
	
	}

}
