package com.fdm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CelMaiMicNumarServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		int[] numbers = new int[4];
		numbers[0] = Integer.parseInt(req.getParameter("n1"));
		numbers[1] = Integer.parseInt(req.getParameter("n2"));
		numbers[2] = Integer.parseInt(req.getParameter("n3"));
		numbers[3] = Integer.parseInt(req.getParameter("n4"));
		
		int minNumber = numbers[0];
		
		for (int i : numbers) {
			if (i < minNumber) {
				minNumber = i;
			}
		}
		PrintWriter out = res.getWriter();
		
		out.write("Cel mai mic numar: " + minNumber);		
		
		
	}	

}
