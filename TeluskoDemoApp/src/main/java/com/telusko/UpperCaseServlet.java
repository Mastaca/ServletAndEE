package com.telusko;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class UpperCaseServlet extends HttpServlet {
	
 	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
 		String text = req.getParameter("name");
 		
 		resp.getWriter().write(text.toUpperCase());
 		
 	}

}
