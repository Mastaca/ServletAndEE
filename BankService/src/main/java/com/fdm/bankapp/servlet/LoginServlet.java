package com.fdm.bankapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdm.bankapp.dao.entities.UserAccountEntity;
import com.fdm.bankapp.service.UserAccountService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		UserAccountEntity userAccountEntity = UserAccountService.getInstance().getUserAccount(email);
		if(UserAccountService.getInstance().verifyCredentials(userAccountEntity, email, password)) {
			HttpSession session = request.getSession();
			String sessionId = session.getId();
			response.setStatus(200);
			response.setHeader("JSESSIONID", sessionId);
//			response.sendRedirect("index.html");
		} else {	
			response.sendRedirect("login.jsp");
		}		
	}

}
