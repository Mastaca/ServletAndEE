package com.fdm.highschool.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fdm.highschool.entities.Clasa;
import com.fdm.highschool.entities.Elev;
import com.fdm.highschool.service.ClasaService;

public class ElevMapper {
	
	private Elev map(ResultSet rs) throws SQLException {			
		int id = rs.getInt(1);
		String nume = rs.getString(2);
		String adresa = rs.getString(3);
		int idClasa = rs.getInt(4);
		String numeClasa = rs.getString(5);
		int numarElevi = rs.getInt(6);
		Clasa clasa = new Clasa(idClasa, numeClasa, numarElevi);
		return new Elev(id, nume, adresa, clasa);
	}
	
	public List<Elev> mapAll(ResultSet rs) throws SQLException {
		List<Elev> elevi = new ArrayList<>();
		while (rs.next()) {
			elevi.add(map(rs));
		}
		return elevi;
	}
}
