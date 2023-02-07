package com.fdm;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ShowCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		Cookie[] cookies = req.getCookies();

		Cookie firstNameCookie = null;
		Cookie lastNameCookie = null;

		if (cookies != null) {

			for (Cookie c : cookies) {
				if (c.getName().equals("firstName")) {
					firstNameCookie = c;
				} else if (c.getName().equals("lastName")) {
					lastNameCookie = c;
				}
			}

			if (firstNameCookie != null && lastNameCookie != null) {
				res.getWriter().write(
						"First name = " + firstNameCookie.getValue() + "  Last name = " + lastNameCookie.getValue());
			} else {
				res.getWriter().write("You are not logged in.");
			}
		} else {
			res.getWriter().write("You are not logged in.");
		}
		
		res.setContentType("text/json");

	}

}
