package com.fdm.highschool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.fdm.highschool.entities.Profesor;

public class ProfesorDaoImpl implements ProfesorDao {
	
	private ProfesorMapper profesorMapper;
	
	public ProfesorDaoImpl(ProfesorMapper profesorMapper) {
		this.profesorMapper = profesorMapper;
	}

	@Override
	public Profesor save(Profesor profesor) throws SQLException {
		if (profesor.getId() == 0) {
			return create(profesor);
		} else {
			return update(profesor);
		}
	}

	private Profesor create(Profesor profesor) throws SQLException {		
		Connection con = JdbcSession.getConnection();
		PreparedStatement st = con.prepareStatement("insert into profesor (nume_profesor, materie) "
				+ "values (?, ?)", Statement.RETURN_GENERATED_KEYS);
		
		st.setString(1, profesor.getNume());
		st.setString(2, profesor.getMaterie().name());
		st.executeUpdate();
		int id;
		try (ResultSet generatedKeys = st.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            else {
                throw new SQLException("Creating profesor failed, no ID obtained.");
            }
        }
		st.close();
		con.close();
		return findById(id);
	}
	
	
	private Profesor update(Profesor profesor) throws SQLException {
		Connection con = JdbcSession.getConnection();
		PreparedStatement st = con.prepareStatement("update profesor set nume_profesor = ?, materie = ? "
				+ "where id = ?");
		
		st.setString(1, profesor.getNume());
		st.setString(2, profesor.getMaterie().name());
		st.setInt(3, profesor.getId());
		st.executeUpdate();		
		st.close();
		con.close();
		return findById(profesor.getId());
	}
	
	@Override
	public void delete(int id) {
		
	}
	
	@Override
	public Profesor findById(int id) throws SQLException {
		
		Connection con = JdbcSession.getConnection();
		PreparedStatement st = con.prepareStatement("select "
				+ "id, nume_profesor, materie from profesor where id = ?");
		
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		return profesorMapper.map(rs);
	}
	
	@Override
	public List<Profesor> findAll() throws SQLException {
		Connection con = JdbcSession.getConnection();
		PreparedStatement st = con.prepareStatement(
				"select id, nume_profesor, materie from profesor");
		ResultSet rs = st.executeQuery();
		List<Profesor> profesori = profesorMapper.mapAll(rs);
		st.close();
		con.close();
		return profesori;
	}
	
}
