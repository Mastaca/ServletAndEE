package com.fdm.highschool.service;

import java.sql.SQLException;
import java.util.List;

import com.fdm.highschool.dao.ElevDao;
import com.fdm.highschool.dao.ElevDaoImpl;
import com.fdm.highschool.dao.ElevMapper;
import com.fdm.highschool.entities.Elev;

public class ElevService {
	
	private ElevDao elevDao;

	private ElevService(ElevDao elevDao) {
		super();
		this.elevDao = elevDao;
	}
	
	public static ElevService getInstance() {
		return new ElevService(new ElevDaoImpl(new ElevMapper()));
	}
	
	public Elev save(Elev elev) throws SQLException {
		return elevDao.save(elev);
	}
	
	public void delete(int id) throws SQLException {
		elevDao.delete(id);
	}
	
	public Elev findById(int id) throws SQLException {
		return elevDao.findById(id);
	}
	
	public List<Elev> findAll() throws SQLException {
		return elevDao.findAll();
	}
	
}
