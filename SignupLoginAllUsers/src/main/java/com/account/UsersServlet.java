package com.account;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/allUsersServlet")
public class UsersServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		
		Cookie[] cookieList = req.getCookies();
		String userName = null;
		
		if (cookieList != null) {
			for (Cookie c : cookieList) {
				if (c.getName().equals("user")) {
					userName = c.getValue();
					break;
				}
			}
		}
	
		if (userName != null) {
			resp.getWriter().write("Hello " + userName + "\n");
			String newline = System.getProperty("line.separator");
			for ( Entry<String, UserAccount> entry : UserAccount.userList.entrySet()) {
				resp.getWriter().write("name: " + entry.getValue().getUserName() + newline);
				resp.getWriter().write("email: " + entry.getValue().getUserEmail() + newline);
			}
		} else {
			resp.sendRedirect("login");
		}
		
		
	}

}
