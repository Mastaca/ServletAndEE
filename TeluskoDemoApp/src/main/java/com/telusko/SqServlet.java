package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/sq")
public class SqServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
//		HttpSession session = req.getSession();
//		
//		int k = (int)session.getAttribute("k");
		
		Cookie[] cookies = req.getCookies();
		
		int k = 0;
		
		for (Cookie c : cookies) {
			if (c.getName().equals("k")) {
				k = Integer.parseInt(c.getValue());
			}
		}
		
		k *= k;
		
		PrintWriter out = res.getWriter(); 
		
		out.println("Result is: " + k);		
		
		System.out.println("sq called");
		
	}	

}
