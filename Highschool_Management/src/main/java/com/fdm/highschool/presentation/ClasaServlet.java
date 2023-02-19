package com.fdm.highschool.presentation;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdm.highschool.entities.Clasa;
import com.fdm.highschool.service.ClasaService;

@WebServlet("/clasa")
public class ClasaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			Clasa clasa = ClasaService.getInstance().findById(id);
		
			request.setAttribute("clasa", clasa);
			
			RequestDispatcher rd = request.getRequestDispatcher("viewClasa.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String numeClasa = req.getParameter("nume");
		
		Clasa clasa = new Clasa(numeClasa, 0);
		
		try {
			Clasa savedClasa = ClasaService.getInstance().save(clasa);
			
			resp.sendRedirect("/Highschool_Management/clasa?id=" + savedClasa.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	


}
