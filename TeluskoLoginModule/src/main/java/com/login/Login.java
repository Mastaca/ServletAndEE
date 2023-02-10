package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		
		if (userName.equals("Telusko") && userPass.equals("learnings")) {			
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			response.sendRedirect("welcome.jsp");			
		} else {
			response.sendRedirect("login.jsp");
		}
	}

}
