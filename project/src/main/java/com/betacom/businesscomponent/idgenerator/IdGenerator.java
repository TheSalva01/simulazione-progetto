package com.betacom.businesscomponent.idgenerator;

import java.io.IOException;

import com.betacom.architecture.dao.DAOException;

public interface IdGenerator {
	public int nextVal() throws ClassNotFoundException, IOException, DAOException;
}
