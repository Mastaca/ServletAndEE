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

@SuppressWarnings("serial")
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
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idString = req.getParameter("id");
		String numeElev = req.getParameter("nume");
		String adresaElev = req.getParameter("adresa");
		if (idString != null) {
			int id = Integer.parseInt(idString);
			Clasa clasa = null;
			try {
				String clasaIdString = req.getParameter("clasa");
				int clasaId = Integer.parseInt(clasaIdString);
				clasa = ClasaService.getInstance().findById(clasaId);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (clasa != null) {
				Elev elev = new Elev(id, numeElev, adresaElev, clasa);
				try {
					Elev savedElev = ElevService.getInstance().save(elev);					
//					int nrElevi = savedElev.getClasa().getNumarElevi();
					clasa.setNumarElevi(clasa.getNumarElevi()+1);
					ClasaService.getInstance().save(clasa);					
					resp.sendRedirect("/Highschool_Management/elev?id=" + savedElev.getId());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
		} else {
			Elev elev = new Elev(numeElev, adresaElev);
			try {
				Elev savedElev = ElevService.getInstance().save(elev);
				resp.sendRedirect("/Highschool_Management/elev?id=" + savedElev.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
