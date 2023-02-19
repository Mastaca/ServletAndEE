package com.fdm.highschool.presentation;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdm.highschool.entities.Elev;
import com.fdm.highschool.service.ElevService;

@WebServlet("/elev")
public class ElevServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			Elev elev = ElevService.getInstance().findById(id);
		
			request.setAttribute("elev", elev);
			
			RequestDispatcher rd = request.getRequestDispatcher("viewElev.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String numeElev = req.getParameter("nume");
		String adresaElev = req.getParameter("adresa");
		
		Elev elev = new Elev(numeElev, adresaElev);
		
		try {
			Elev savedElev = ElevService.getInstance().save(elev);
			
			resp.sendRedirect("/Highschool_Management/elev?id=" + savedElev.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
