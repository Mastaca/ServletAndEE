package com.account;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/signupServlet")
public class SignupServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String userName = req.getParameter("userName");
		String userPassword = req.getParameter("userPassword");
		String userEmail = req.getParameter("userEmail");
		
		if(UserAccount.userList.get(userName) != null) {
			resp.getWriter().write("User already exists");
		} else {
			UserAccount newAccount = new UserAccount(userName, userPassword, userEmail);
			UserAccount.userList.put(userName, newAccount);
			resp.sendRedirect("login");
		}	
		
	}
	
}
