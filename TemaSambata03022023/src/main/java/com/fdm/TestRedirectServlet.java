package com.fdm;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class TestRedirectServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		int nextPage = Integer.parseInt(req.getParameter("next"));
		
		switch (nextPage) {
		case 0: 
			res.sendRedirect("index.html");
			break;		
		case 1:
			res.sendRedirect("celMaiMicNumar.html");
			break;
		case 2:
			res.sendRedirect("celMaiMareNumar.html");
			break;
		case 3:
			res.sendRedirect("upperCase.html");
			break;				
		}
		
	}	

}
