package com.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.betacom.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaDAO implements DAOConstants {
	private CachedRowSet rowSet;

	public static CorsoCorsistaDAO getFactory() throws DAOException {
		return new CorsoCorsistaDAO();
	}
	
	private CorsoCorsistaDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException exc) {
			throw new DAOException(exc);
		}

	}

	public void create(Connection conn, CorsoCorsista object) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSO_CORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, object.getCodCorso());
			rowSet.updateLong(2, object.getCodCorsista());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException exc) {
			throw new DAOException(exc);
		}
	}

	public CorsoCorsista getByCourse(Connection conn, CorsoCorsista entity) throws DAOException {
		CorsoCorsista corsoCorsista = new CorsoCorsista();
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_CORSO_CORSISTA_BYID);
			ps.setLong(1, entity.getCodCorso());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				corsoCorsista.setCodCorso(rs.getLong(1));
				corsoCorsista.setCodCorsista(rs.getLong(2));
			}
		} catch (SQLException exc) {
			throw new DAOException(exc);
		}
		return corsoCorsista;
	}
	
	public List<CorsoCorsista> getAll(Connection conn) throws DAOException {
		List<CorsoCorsista> corsoCorsisti = new ArrayList<>();

		try {
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = statement.executeQuery(SELECT_CORSO_CORSISTA);
			rs.beforeFirst();
			while(rs.next()) {
				CorsoCorsista corsoCorsista = new CorsoCorsista();
				corsoCorsista.setCodCorso(rs.getLong(1));
				corsoCorsista.setCodCorsista(rs.getLong(2));

				corsoCorsisti.add(corsoCorsista);
			}
		} catch (SQLException exc) {
			throw new DAOException(exc);
		}

		return corsoCorsisti;
	}

	
	public int getTrendCourseId(Connection conn) throws DAOException {
		int trendingCourseId = 0;
		try {
			Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			int maxCorsisti = 0; 
			
			ResultSet rs = statement.executeQuery(SELECT_TRENDING_CORSO);
			rs.beforeFirst();
			while(rs.next()) {
				int corso = rs.getInt(1);
				int corsisti = rs.getInt(2);
				
				if(trendingCourseId == 0) {
					trendingCourseId = corso;
				} else if(corsisti > maxCorsisti){
					trendingCourseId = corso; 
					maxCorsisti = corsisti; 
				}
			}
		} catch (SQLException exc) {
			throw new DAOException(exc);
		}
		
		return trendingCourseId;
	}

	public void delete(Connection conn, CorsoCorsista corsoCorsista) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSO_CORSISTA);
			ps.setLong(1, corsoCorsista.getCodCorso());
			ps.setLong(2, corsoCorsista.getCodCorsista());
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
}
