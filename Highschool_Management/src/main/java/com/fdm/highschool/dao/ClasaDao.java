package com.fdm.highschool.dao;

import java.sql.SQLException;
import java.util.List;

import com.fdm.highschool.entities.Clasa;
import com.fdm.highschool.entities.Profesor;

public interface ClasaDao {
	
	Clasa save(Clasa clasa) throws SQLException;
	void delete(int id) throws SQLException;
	Clasa findById(int id) throws SQLException;
	List<Clasa> findAll() throws SQLException;
	List<Profesor> findProfs(int idClasa) throws SQLException;
	void addProfessor(int idClasa, int idProfesor) throws SQLException;
	
}
