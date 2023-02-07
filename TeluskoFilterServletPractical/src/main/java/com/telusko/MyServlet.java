package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addAlien")
public class MyServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		
		int anId = Integer.parseInt(request.getParameter("anId"));
		String aName = request.getParameter("aName");
		
		out.write("welcome " + aName);
		
	}
}
