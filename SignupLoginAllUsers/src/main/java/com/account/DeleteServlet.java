package com.account;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {		
		
		String username = req.getParameter("userName");
		UserAccount.userList.remove(username);
		
		resp.sendRedirect("allUsersServlet");
		
	}

}
