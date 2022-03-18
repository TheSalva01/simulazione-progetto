package com.betacom.architecture.dao;

import java.sql.Connection;

public interface GenericDAO<T> {
	
	public void create(Connection conn, T entity) throws DAOException;

	public void update(Connection conn, T entity) throws DAOException;

	public void delete(Connection conn, T entity) throws DAOException;

	public T getById(Connection conn, long id) throws DAOException;

	public T[] getAll(Connection conn) throws DAOException;
	
}
