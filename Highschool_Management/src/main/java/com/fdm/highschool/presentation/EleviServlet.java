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

@WebServlet("/elevi")
public class EleviServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public EleviServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("elevi", ElevService.getInstance().findAll());
			RequestDispatcher rd = request.getRequestDispatcher("viewElevi.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("modify");
		try {
			if ("edit".equals(button)) {
				int id = Integer.parseInt(request.getParameter("id"));
//				response.sendRedirect("updateElev?id="+id);
				request.getRequestDispatcher("updateElev").forward(request, response);
			} else if("delete".equals(button)) {
				int id = Integer.parseInt(request.getParameter("id"));
				if (ElevService.getInstance().findById(id).getClasa() != null) {
					Elev elev = ElevService.getInstance().findById(id);
					Clasa clasa = elev.getClasa();
					clasa.setNumarElevi(clasa.getNumarElevi()-1);
					ClasaService.getInstance().save(clasa);
				}
				ElevService.getInstance().delete(id);
				
				response.sendRedirect("/Highschool_Management/elevi");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
