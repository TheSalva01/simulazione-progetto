package com.betacom.businesscomponent.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.betacom.architecture.dao.DAOConstants;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;

public class LoginUtility implements DAOConstants {
	private Connection conn;

	public LoginUtility() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public String getCodAdmin(String nome_admin) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_CODADMIN);
			ps.setString(1, nome_admin);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return rs.getString(1);
			return null;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
}
