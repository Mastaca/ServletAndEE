package com.fdm.bankapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdm.bankapp.service.BankAccountService;
import com.fdm.bankapp.service.exception.InsufficientFundsException;

@WebServlet("/bankWithdrawal")
public class BankAccountWithdrawal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BankAccountWithdrawal() {        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iban = request.getParameter("iban");
		int suma = Integer.parseInt(request.getParameter("suma"));	
		try {
			response.getWriter().write(BankAccountService.getInstance().withdrawal(iban, suma).toString());
		} catch (InsufficientFundsException e) {
			response.getWriter().write(e.getMessage());
		}		
	}

}
