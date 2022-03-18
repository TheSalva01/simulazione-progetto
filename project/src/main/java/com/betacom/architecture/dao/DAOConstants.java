package com.betacom.architecture.dao;

public interface DAOConstants {

	String SELECT_CORSO_CORSISTA = "select * from corso_corsista";
	String SELECT_CORSO_CORSISTA_BYID = "select * from corso_corsista where cod_corso = ?";
	
	String SELECT_CORSISTA_SEQ = "select corsista_seq.nextval from dual";
	String SELECT_CORSISTI = "select * from corsista";
}
