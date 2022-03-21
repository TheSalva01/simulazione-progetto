package com.betacom.businesscomponent.utility;

import java.io.IOException;

import com.betacom.architecture.dao.DAOConstants;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;

public class LogoutUtility implements DAOConstants {

	public LogoutUtility() throws DAOException, ClassNotFoundException, IOException {
		DBAccess.closeConnection();
	}
}