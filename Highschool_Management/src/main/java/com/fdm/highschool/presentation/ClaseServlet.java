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
import com.fdm.highschool.entities.Elev;
import com.fdm.highschool.service.ClasaService;
import com.fdm.highschool.service.ElevService;

@WebServlet("/clase")
public class ClaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ClaseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("clase", ClasaService.getInstance().findAll());
			RequestDispatcher rd = request.getRequestDispatcher("viewClase.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("modify");
		try {
			if ("edit".equals(button)) {
				request.getRequestDispatcher("updateClasa").forward(request, response);
			} else if("delete".equals(button)) {
				int id = Integer.parseInt(request.getParameter("id"));
				Clasa clasa = ClasaService.getInstance().findById(id);
				if (clasa != null) {
					if (clasa.getNumarElevi() == 0) {
						ClasaService.getInstance().delete(id);
					} else {
						response.sendRedirect("/Highschool_Management/clase?isEmpty=suntElevi");
					}
				} else {
				response.sendRedirect("/Highschool_Management/clase");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
