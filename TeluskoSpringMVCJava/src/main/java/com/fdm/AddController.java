package com.fdm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fdm.Sevice.AddService;

@Controller
public class AddController {
	
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("t1") int i, @RequestParam("t2") int j, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		
//		int i = Integer.parseInt(httpServletRequest.getParameter("t1"));
//		int j = Integer.parseInt(httpServletRequest.getParameter("t2"));

		AddService addService = new AddService();
		int k = addService.add(i, j);
		
		ModelAndView modelAndView =  new ModelAndView();
		
		modelAndView.setViewName("result.jsp");
		modelAndView.addObject("result", k);
		
		return modelAndView;
	
	}

}
