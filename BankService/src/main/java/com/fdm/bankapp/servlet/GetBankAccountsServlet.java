package com.fdm.bankapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdm.bankapp.dao.entities.BankAccountEntity;
import com.fdm.bankapp.service.UserAccountService;

/**
 * Servlet implementation class GetBankAccountsServlet
 */
@WebServlet("/userAccount/bankAccounts")
public class GetBankAccountsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetBankAccountsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("user_id"));
		List<BankAccountEntity> listBankAccounts =UserAccountService.getInstance().getBankAccounts(id);
		StringBuilder sb = new StringBuilder();
		for (BankAccountEntity b : listBankAccounts) {
			sb.append(b.toString());
		}
		response.getWriter().write(sb.toString());		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
