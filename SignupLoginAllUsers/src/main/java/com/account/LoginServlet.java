package com.account;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String userName = req.getParameter("userName");
		String userPassword = req.getParameter("userPassword");
				
		if(UserAccount.userList.get(userName) != null) {
			UserAccount user = UserAccount.userList.get(userName);
			if (userPassword.equals(user.getUserPassword())) {
				Cookie cookie = new Cookie("user", user.getUserName());
				resp.addCookie(cookie);
				resp.sendRedirect("allUsersServlet");
			} else {
				resp.sendRedirect("login");
			}
		} else {
			resp.sendRedirect("login");
		}	
		
	}	
	
}
