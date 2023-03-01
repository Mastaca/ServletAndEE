package com.fdm.bankapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdm.bankapp.service.BankAccountService;
import com.fdm.bankapp.service.exception.IncorrectCurrencyException;
import com.fdm.bankapp.service.exception.InsufficientFundsException;

@WebServlet("/bankTransfer")
public class BankAccountTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BankAccountTransferServlet() {        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String senderIban = request.getParameter("senderIban");
		String recipientIban = request.getParameter("recipientIban");
		int suma = Integer.parseInt(request.getParameter("suma"));		
		try {
			response.getWriter().write(BankAccountService.getInstance().transfer(senderIban, recipientIban, suma).toString());
		} catch (InsufficientFundsException e) {
			response.getWriter().write(e.getMessage());
		} catch (IncorrectCurrencyException e) {
			response.getWriter().write(e.getMessage());					
		}				
	}

}
