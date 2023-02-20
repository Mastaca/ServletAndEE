package com.fdm.highschool.dao;

import java.sql.SQLException;
import java.util.List;

import com.fdm.highschool.entities.Elev;

public interface ElevDao {
	
	Elev save( Elev elev) throws SQLException;
	void delete(int id) throws SQLException;
	Elev findById(int id) throws SQLException;
	List<Elev> findAll() throws SQLException;
	
}
