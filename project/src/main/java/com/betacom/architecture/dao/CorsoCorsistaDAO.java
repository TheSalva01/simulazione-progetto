package com.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.betacom.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaDAO extends GenericDAO<CorsoCorsista> implements DAOConstants {
	private CachedRowSet rowSet;
	
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
			rowSet.execute();
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

	@Override
	public void update(Connection conn, CorsoCorsista entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection conn, CorsoCorsista entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CorsoCorsista getById(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CorsoCorsista[] getAll(Connection conn) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
