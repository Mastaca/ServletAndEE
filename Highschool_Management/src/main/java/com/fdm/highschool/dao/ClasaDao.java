package com.fdm.highschool.dao;

import java.sql.SQLException;
import java.util.List;

import com.fdm.highschool.entities.Clasa;
import com.fdm.highschool.entities.Elev;

public interface ClasaDao {
	
	Clasa save(Clasa clasa) throws SQLException;
	void delete(int id);
	Clasa findById(int id) throws SQLException;
	List<Clasa> findAll() throws SQLException;
}
