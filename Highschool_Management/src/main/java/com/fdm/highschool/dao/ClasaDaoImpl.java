package com.fdm.highschool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.fdm.highschool.entities.Clasa;
import com.fdm.highschool.entities.Profesor;

public class ClasaDaoImpl implements ClasaDao {
	
	private ClasaMapper clasaMapper;
	
	public ClasaDaoImpl(ClasaMapper clasaMapper) {
		this.clasaMapper = clasaMapper;
	}

	@Override
	public Clasa save(Clasa clasa) throws SQLException {
		if (clasa.getId() == 0) {
			return create(clasa);
		} else {
			return update(clasa);
		}		
	}

	private Clasa create(Clasa clasa) throws SQLException {
		Connection con = JdbcSession.getConnection();
		PreparedStatement st = con.prepareStatement(
				"insert into clasa (nume_clasa, numar_elevi) "
				+ "values (?, 0)", Statement.RETURN_GENERATED_KEYS);
		
		st.setString(1, clasa.getNume());
		st.executeUpdate();
		int id;
		try (ResultSet generatedKeys = st.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }
		st.close();
		con.close();
		return findById(id);
	}
	
	private Clasa update(Clasa clasa) throws SQLException {
		Connection con = JdbcSession.getConnection();
		PreparedStatement st = con.prepareStatement("update clasa set nume_clasa = ?, numar_elevi = ? "
				+ "where id = ?");
		
		st.setString(1, clasa.getNume());
		st.setInt(2, clasa.getNumarElevi());
		st.setInt(3, clasa.getId());
		st.executeUpdate();		
		st.close();
		con.close();		
		return findById(clasa.getId());
	}
	
	@Override
	public void delete(int id) throws SQLException {
		Connection con = JdbcSession.getConnection();
		PreparedStatement st = con.prepareStatement("delete from clasa where id = ?");		
		st.setInt(1, id);
		st.executeUpdate();
		st.close();
		con.close();
	}

	@Override
	public Clasa findById(int id) throws SQLException {
		Connection con = JdbcSession.getConnection();
		PreparedStatement st = con.prepareStatement("select "
				+ "id, nume_clasa, numar_elevi from clasa where id = ?");		
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		return clasaMapper.map(rs);
	}

	@Override
	public List<Clasa> findAll() throws SQLException {
		Connection con = JdbcSession.getConnection();
		PreparedStatement st = con.prepareStatement("select id, nume_clasa, numar_elevi from clasa");
		ResultSet rs = st.executeQuery();
		List<Clasa> clase = clasaMapper.mapAll(rs);
		st.close();
		con.close();
		return clase;
	}
	
	public List<Profesor> findProfs(int idClasa) throws SQLException {
		Connection con = JdbcSession.getConnection();
		PreparedStatement st = con.prepareStatement("select profesor_id from clase_profesori where clasa_id=?");
		st.setInt(1, idClasa);
		ResultSet rs = st.executeQuery();
		List<Profesor> listaProfesori = clasaMapper.mapProfesori(rs);
		st.close();
		con.close();
		return listaProfesori;
	}

	@Override
	public void addProfessor(int idClasa, int idProfesor) throws SQLException {
		Connection con = JdbcSession.getConnection();
		PreparedStatement st = con.prepareStatement(
				"insert into clase_profesori (clasa_id, profesor_id)"
				+ "values (?,?);");
		st.setInt(1, idClasa);
		st.setInt(2, idProfesor);
		st.executeUpdate();
		st.close();
		con.close();
	}
	
}
