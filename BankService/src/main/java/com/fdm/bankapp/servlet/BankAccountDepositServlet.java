package com.fdm.bankapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdm.bankapp.service.BankAccountService;

@WebServlet("/bankDeposit")
public class BankAccountDepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BankAccountDepositServlet() {        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iban = request.getParameter("iban");
		int suma = Integer.parseInt(request.getParameter("suma"));
		response.getWriter().write(BankAccountService.getInstance().deposit(iban, suma).toString());		
	}

}
