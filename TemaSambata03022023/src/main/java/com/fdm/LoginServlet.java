package com.fdm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings({ "serial", "unused" })
public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String userName = req.getParameter("userName");
		String userPass = req.getParameter("userPass");
		
		if (userName.equals("Edi") && (userPass.equals("edi1234"))) {
			Cookie firstNameCookie = new Cookie("firstName", "Eduard");
			Cookie lastNameCookie = new Cookie("lastName", "Katyi");
			res.addCookie(firstNameCookie);
			res.addCookie(lastNameCookie);
		} else {
			res.sendRedirect("login");
		}
		
		
	}
	
}
