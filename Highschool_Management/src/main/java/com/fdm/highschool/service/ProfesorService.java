package com.fdm.highschool.service;

import java.sql.SQLException;
import java.util.List;

import com.fdm.highschool.dao.ProfesorDao;
import com.fdm.highschool.dao.ProfesorDaoImpl;
import com.fdm.highschool.dao.ProfesorMapper;
import com.fdm.highschool.entities.Profesor;

public class ProfesorService {
	
	private ProfesorDao profesorDao;
	
	private ProfesorService(ProfesorDao profesorDao) {
		super();
		this.profesorDao = profesorDao;
	}
	
	public static ProfesorService getInstance() {
		return new ProfesorService(new ProfesorDaoImpl(new ProfesorMapper()));
	}
	
	public Profesor save(Profesor profesor) throws SQLException {
		return profesorDao.save(profesor);
	}
	
	public void delete(int id) throws SQLException {
		profesorDao.delete(id);
	}
	
	public Profesor findById(int id) throws SQLException {
		return profesorDao.findById(id);
	}
	
	public List<Profesor> findAll() throws SQLException {
		return profesorDao.findAll();
	}
	
}
