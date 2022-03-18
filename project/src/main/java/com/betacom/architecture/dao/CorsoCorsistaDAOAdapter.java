package com.betacom.architecture.dao;

import java.sql.Connection;

import com.betacom.businesscomponent.model.CorsoCorsista;

public abstract class CorsoCorsistaDAOAdapter implements GenericDAO<CorsoCorsista> {

	@Override
	public CorsoCorsista getById(Connection conn, long id) throws DAOException {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void delete(Connection conn, CorsoCorsista entity) throws DAOException {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void update(Connection conn, CorsoCorsista entity) throws DAOException {
		throw new UnsupportedOperationException();
	}
	
}
