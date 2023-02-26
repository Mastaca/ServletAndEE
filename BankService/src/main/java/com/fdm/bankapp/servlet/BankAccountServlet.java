package com.fdm.bankapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdm.bankapp.dao.entities.BankAccountEntity;
import com.fdm.bankapp.dao.entities.Moneda;
import com.fdm.bankapp.dao.entities.UserAccountEntity;
import com.fdm.bankapp.service.BankAccountService;

@WebServlet("/bankAccount")
public class BankAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BankAccountServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int id = Integer.parseInt(request.getParameter("bankAccount_id"));
		BankAccountEntity bae = BankAccountService.getInstance().getBankAccount(id);
		response.getWriter().write(bae.toString());		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String iban = request.getParameter("iban");
		Moneda moneda = Moneda.valueOf(request.getParameter("moneda"));
		int user_id = Integer.parseInt(request.getParameter("user_id"));	
		
		UserAccountEntity uae = new UserAccountEntity(user_id);		
		BankAccountEntity bae = new BankAccountEntity(iban, moneda, uae);		
		BankAccountService bas = BankAccountService.getInstance();		
		BankAccountEntity savedBae = bas.save(bae);		
		response.getWriter().write(savedBae.toString());
	}

}
