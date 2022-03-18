package com.betacom.architecture.dao;

import java.sql.SQLException;

public class DAOException extends SQLException {
	private static final long serialVersionUID = -8273620554038680419L;
	
	private final static int ORA01017 = 1017;
	private final static int ORA17002 = 17002;
	private final static int ORA00001 = 0;
	
	private String message;

	@Override
	public String getMessage() {
		return message;
	}
	
	public DAOException(SQLException sql) {
		String chiave = "";
		if(sql != null) {
			switch(sql.getErrorCode()) {
			case ORA01017: 
				chiave = "username/password invalidi";
				log(sql);
				break;
			case ORA17002:
				chiave = "IO exception di Oracle DB";
				log(sql);
				break;
			case ORA00001:
				chiave = "Vincolo di tabella violato";
				log(sql);
				break;
			default:
				chiave = "Eccezione SQL non prevista";
				log(sql);
				break;
			}
		}
		message = chiave;
	}

	private void log(SQLException sql) {
		sql.printStackTrace();
		System.err.println("Motivo: "+sql.getMessage());
		System.err.println("Stato app: "+sql.getSQLState());
		System.err.println("Codice errore: "+sql.getErrorCode());
		System.err.println("Causa del problema: "+sql.getCause());
	}	
}

