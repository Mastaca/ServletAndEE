package com.fdm.highschool.presentation;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdm.highschool.entities.Materie;
import com.fdm.highschool.entities.Profesor;
import com.fdm.highschool.service.ProfesorService;

@WebServlet("/profesor")
public class ProfesorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			Profesor profesor = ProfesorService.getInstance().findById(id);
			request.setAttribute("profesor", profesor);
			RequestDispatcher rd = request.getRequestDispatcher("viewProfesor.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String numeProfesor = req.getParameter("nume");
		String materieprofesor = req.getParameter("materie");
		Materie materie = Materie.valueOf(materieprofesor);
		String idString = req.getParameter("id");	
		int id;
		Profesor profesor;
		if (idString != null) {
			id = Integer.parseInt(idString);
			profesor = new Profesor(id,numeProfesor, materie);
		} else {
			profesor = new Profesor(numeProfesor, materie);
		}
		
		
		try {
			Profesor savedProfesor = ProfesorService.getInstance().save(profesor);
			resp.sendRedirect("/Highschool_Management/profesor?id=" + savedProfesor.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
