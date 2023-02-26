package com.fdm.bankapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdm.bankapp.dao.entities.UserAccountEntity;
import com.fdm.bankapp.service.UserAccountService;

@WebServlet("/userAccount")
public class UserAccountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String parola = request.getParameter("parola");
		String cnp = request.getParameter("cnp");
		String nume = request.getParameter("nume");		
		
		UserAccountEntity uae = new UserAccountEntity(email, parola, cnp, nume);		
		UserAccountService uas = UserAccountService.getInstance();		
		UserAccountEntity savedUae = uas.save(uae);
		
		response.getWriter().write(savedUae.toString());		
	}

}
