package com.fdm.highschool.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fdm.highschool.entities.Clasa;
import com.fdm.highschool.entities.Materie;
import com.fdm.highschool.entities.Profesor;
import com.fdm.highschool.service.ProfesorService;

public class ClasaMapper {
	
	public Clasa map(ResultSet rs) throws SQLException {
	
		if (rs.next()) {
			int id = rs.getInt(1);
			String nume = rs.getString(2);
			int nr = rs.getInt(3);
			return new Clasa(id, nume, nr);
		} else {
			return null;
		}
	}

	public List<Clasa> mapAll(ResultSet rs) throws SQLException {
		List<Clasa> clase = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt(1);
			String nume = rs.getString(2);
			int numarElevi = rs.getInt(3);
			clase.add(new Clasa(id, nume, numarElevi));
		}
		return clase;
	}
	
	public List<Profesor> mapProfesori(ResultSet rs) throws SQLException {
		List<Profesor> listaProf = new ArrayList<>();
		while (rs.next()) {
			int idProfesor = rs.getInt(1);			
			listaProf.add(ProfesorService.getInstance().findById(idProfesor));
		}
		return listaProf;
	}
}
