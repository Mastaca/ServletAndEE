package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MyServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		PrintWriter printWriter = res.getWriter();
		
		printWriter.print("Hi, ");
		
		int  k = 9/0;
		
		
		
		/*
		 * ServletContext ctx = getServletContext(); String str =
		 * ctx.getInitParameter("name");
		 */
		
		ServletConfig ctx = getServletConfig();
		String str = ctx.getInitParameter("name");
		
		printWriter.print(str);
		
		
	}
	
}
