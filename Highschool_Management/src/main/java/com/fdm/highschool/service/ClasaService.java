package com.fdm.highschool.service;

import java.sql.SQLException;
import java.util.List;

import com.fdm.highschool.dao.ClasaDao;
import com.fdm.highschool.dao.ClasaDaoImpl;
import com.fdm.highschool.dao.ClasaMapper;
import com.fdm.highschool.entities.Clasa;

public class ClasaService {
	
	private ClasaDao clasaDao;
	
	private ClasaService(ClasaDao clasaDao) {
		super();
		this.clasaDao = clasaDao;
	}
	
	public static ClasaService getInstance() {
		return new ClasaService(new ClasaDaoImpl(new ClasaMapper()));
	}
	
	public Clasa save(Clasa clasa) throws SQLException {
		return clasaDao.save(clasa);
	}
	
	public Clasa findById(int id) throws SQLException {
		return clasaDao.findById(id);
	}
	
	public List<Clasa> findAll() throws SQLException {		
		return clasaDao.findAll();
	}
	
}
