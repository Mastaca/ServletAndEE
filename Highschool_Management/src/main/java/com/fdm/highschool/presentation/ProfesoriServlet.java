package com.fdm.highschool.presentation;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdm.highschool.entities.Profesor;
import com.fdm.highschool.service.ProfesorService;

@WebServlet("/profesori")
public class ProfesoriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ProfesoriServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("profesori", ProfesorService.getInstance().findAll());
			RequestDispatcher rd = request.getRequestDispatcher("viewProfesori.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("modify");
		if ("edit".equals(button)) {
			request.getRequestDispatcher("updateProfesor").forward(request, response);
		} else if("delete".equals(button)) {
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				ProfesorService.getInstance().delete(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}			
			response.sendRedirect("/Highschool_Management/profesori");
		}
	}

}
