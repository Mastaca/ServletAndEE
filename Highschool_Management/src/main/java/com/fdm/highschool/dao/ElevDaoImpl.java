package com.fdm.highschool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.fdm.highschool.entities.Elev;

public class ElevDaoImpl implements ElevDao {
	
	private ElevMapper elevMapper;
	
	public ElevDaoImpl(ElevMapper elevMapper) {
		this.elevMapper = elevMapper;
	}

	@Override
	public Elev save(Elev elev) throws SQLException {
		if (elev.getId() == 0) {
			return create(elev);
		} else {
			return update(elev);
		}		
	}

	private Elev create(Elev elev) throws SQLException {
		Connection con = JdbcSession.getConnection();
		PreparedStatement st = con.prepareStatement("insert into elev (nume_elev, adresa_elev) "
				+ "values (?, ?)", Statement.RETURN_GENERATED_KEYS);
		
		st.setString(1, elev.getNume());
		st.setString(2, elev.getAdresa());
		st.executeUpdate();
		int id;
		try (ResultSet generatedKeys = st.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }
		st.close();
		con.close();
		return findById(id);
	}
	
	private Elev update(Elev elev) throws SQLException {
		Connection con = JdbcSession.getConnection();
		PreparedStatement st = con.prepareStatement("update elev set nume_elev = ?, adresa_elev = ?, clasa_id = ? "
				+ "where id = ?");
		
		st.setString(1, elev.getNume());
		st.setString(2, elev.getAdresa());
		st.setInt(3, elev.getClasa().getId());
		st.setInt(4, elev.getId());
		st.executeUpdate();
		st.close();
		con.close();
		return findById(elev.getId());
	}
	
	@Override
	public void delete(int id) throws SQLException {
		Connection con = JdbcSession.getConnection();
		PreparedStatement st = con.prepareStatement("delete from elev where id = ?");		
		st.setInt(1, id);
		st.executeUpdate();
		st.close();
		con.close();		
	}

	@Override
	public Elev findById(int id) throws SQLException {
		Connection con = JdbcSession.getConnection();
		PreparedStatement st = con.prepareStatement("select "
				+ "id, nume_elev, adresa_elev, clasa_id from elev where id = ?");
		
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		Elev elev = elevMapper.map(rs);
		st.close();
		con.close();
		return elev;
	}

	@Override
	public List<Elev> findAll() throws SQLException {
		Connection con = JdbcSession.getConnection();
		PreparedStatement st = con.prepareStatement("select id, nume_elev, adresa_elev, clasa_id from elev");
		ResultSet rs = st.executeQuery();
		List<Elev> elevi = elevMapper.mapAll(rs);
		st.close();
		con.close();
		return elevi;
	}

}
