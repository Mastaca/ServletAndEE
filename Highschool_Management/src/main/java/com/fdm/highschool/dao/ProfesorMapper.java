package com.fdm.highschool.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fdm.highschool.entities.Clasa;
import com.fdm.highschool.entities.Elev;
import com.fdm.highschool.entities.Materie;
import com.fdm.highschool.entities.Profesor;

public class ProfesorMapper {
	
	public Profesor map(ResultSet rs) throws SQLException {
	
		if (rs.next()) {
			int id = rs.getInt(1);
			String nume = rs.getString(2);
			Materie materie = Materie.valueOf(rs.getString(3));
			return new Profesor(id, nume, materie);
		} else {
			return null;
		}
	}
	
	public List<Profesor> mapAll(ResultSet rs) throws SQLException {
		List<Profesor> profesori = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt(1);
			String nume = rs.getString(2);
			Materie materie = Materie.valueOf(rs.getString(3));
			profesori.add(new Profesor(id, nume, materie));
		}
		return profesori;
	}

}
