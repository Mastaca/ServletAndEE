package com.fdm.bankapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdm.bankapp.dao.entities.BankAccountEntity;
import com.fdm.bankapp.service.BankAccountService;

@WebServlet("/bankAction")
public class BankAccountActionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BankAccountActionsServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bankId = Integer.parseInt(request.getParameter("bank_id"));
		int suma = Integer.parseInt(request.getParameter("suma"));
		String bankAction = request.getParameter("action");
		BankAccountService bankAccountService = BankAccountService.getInstance();
		if (bankAction != null) {		
			if ("deposit".equals(bankAction)) {
				response.getWriter().write(bankAccountService.deposit(bankId, suma).toString());
			} else if ("withdrawal".equals(bankAction)) {
				response.getWriter().write(bankAccountService.withdrawal(bankId, suma).toString());
			} else if ("transfer".equals(bankAction)) {
				int recipientID = Integer.parseInt(request.getParameter("recipientID"));
				response.getWriter().write(bankAccountService.transfer(bankId, recipientID ,suma).toString());
				response.getWriter().write(bankAccountService.getInstance().getBankAccount(recipientID).toString());
			}
			
		}
		
		
	}

}
