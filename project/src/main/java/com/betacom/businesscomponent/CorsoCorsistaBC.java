package com.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import com.betacom.architecture.dao.CorsoCorsistaDAO;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaBC {
	private Connection conn; 
	
	public CorsoCorsistaBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void create(CorsoCorsista corsoCorsista) throws DAOException {
		CorsoCorsistaDAO.getFactory().create(conn, corsoCorsista);
	}
	
	
}
