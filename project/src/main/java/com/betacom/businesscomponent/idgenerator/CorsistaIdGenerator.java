package com.betacom.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.betacom.architecture.dao.DAOConstants;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;

public class CorsistaIdGenerator implements IdGenerator, DAOConstants{
	private CorsistaIdGenerator instance;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private CorsistaIdGenerator()
			throws ClassNotFoundException, IOException, DAOException {
		conn = DBAccess.getConnection();
	}
	
	public CorsistaIdGenerator getInstance() throws ClassNotFoundException, IOException, DAOException {
		if(instance == null)
			instance = new CorsistaIdGenerator();
		return instance;
	}

	@Override
	public int nextVal() throws ClassNotFoundException, IOException, DAOException{
		int newId;
		try{
			stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(SELECT_CORSISTA_SEQ);
			rs.next();
			newId = rs.getInt(1);
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return newId;
	}
	

}
