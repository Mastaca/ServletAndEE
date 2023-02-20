package com.fdm.highschool.dao;

import java.sql.SQLException;
import java.util.List;

import com.fdm.highschool.entities.Profesor;

public interface ProfesorDao {
	
	Profesor save(Profesor profesor) throws SQLException;
	void delete(int id) throws SQLException;
	Profesor findById(int id) throws SQLException;
	List<Profesor> findAll() throws SQLException;
	
}
