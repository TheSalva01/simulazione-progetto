package com.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.betacom.architecture.dao.CorsistaDAO;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.idgenerator.CorsistaIdGenerator;
import com.betacom.businesscomponent.model.Corsista;

public class CorsistaBC {
	private Connection conn;
	
	public CorsistaBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void create(Corsista corsista)
			throws ClassNotFoundException, IOException, DAOException {
		try {
			corsista.setCodCorsista(CorsistaIdGenerator.getInstance().nextVal());
			CorsistaDAO.getFactory().create(conn, corsista);
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public List<Corsista> getAll() throws DAOException{
		try {
			return CorsistaDAO.getFactory().getAll(conn);
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public int getNumber() throws DAOException {
		try {
			return CorsistaDAO.getFactory().getAll(conn).size();
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
}
