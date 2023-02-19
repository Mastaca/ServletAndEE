package com.fdm.highschool.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fdm.highschool.entities.Clasa;
import com.fdm.highschool.entities.Elev;

public class ElevMapper {
	
	public Elev map(ResultSet rs) throws SQLException {
	
		if (rs.next()) {
			int id = rs.getInt(1);
			String nume = rs.getString(2);
			String adresa = rs.getString(3);
			return new Elev(id, nume, adresa);
		} else {
			return null;
		}
	}
	
	public List<Elev> mapAll(ResultSet rs) throws SQLException {
		List<Elev> elevi = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt(1);
			String nume = rs.getString(2);
			String adresa = rs.getString(3);
			int clasaId = rs.getInt(4);
			elevi.add(new Elev(id, nume, adresa, new Clasa(clasaId)));
		}
		return elevi;
	}
}
