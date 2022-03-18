package com.betacom.architecture.dao;

import java.sql.Connection;

public abstract class GenericDAO<T> {
	
	public abstract void create(Connection conn, T entity) throws DAOException;

	public abstract void update(Connection conn, T entity) throws DAOException;

	public abstract void delete(Connection conn, T entity) throws DAOException;

	public abstract T getById(Connection conn, long id) throws DAOException;

	public abstract T[] getAll(Connection conn) throws DAOException;
	
}
