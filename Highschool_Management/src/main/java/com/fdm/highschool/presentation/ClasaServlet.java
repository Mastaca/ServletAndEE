package com.fdm.highschool.presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdm.highschool.entities.Clasa;
import com.fdm.highschool.entities.Profesor;
import com.fdm.highschool.service.ClasaService;
import com.fdm.highschool.service.ProfesorService;

@WebServlet("/clasa")
public class ClasaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			Clasa clasa = ClasaService.getInstance().findById(id);
			request.setAttribute("clasa", clasa);			
			RequestDispatcher rd = request.getRequestDispatcher("viewClasa.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String numeClasa = req.getParameter("nume");
		String numarElevi = req.getParameter("nrElevi");
		Clasa clasa; 
		String idProfString = req.getParameter("chosenProfesor");
		if (idProfString != null) {
			int idProfesor = Integer.parseInt(idProfString);
			int idClasa = Integer.parseInt(req.getParameter("id"));
			try {
				ClasaService.getInstance().addProfessor(idClasa,idProfesor);
//				clasa = new Clasa(numeClasa, Integer.parseInt(numarElevi));
//				Clasa savedClasa = ClasaService.getInstance().save(clasa);				
				resp.sendRedirect("/Highschool_Management/clasa?id=" + idClasa);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {		
			clasa = new Clasa(numeClasa, 0);					
			try {
				Clasa savedClasa = ClasaService.getInstance().save(clasa);				
				resp.sendRedirect("/Highschool_Management/clasa?id=" + savedClasa.getId());
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
	}
}
