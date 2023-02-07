package com.fdm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ForwardToUpperCaseServlet extends HttpServlet {
	 	
 	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
 		RequestDispatcher rd = req.getRequestDispatcher("upperCase");
 		rd.forward(req, resp);
		
	}

}
