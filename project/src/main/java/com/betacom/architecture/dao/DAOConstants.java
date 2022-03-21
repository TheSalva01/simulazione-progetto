package com.betacom.architecture.dao;

public interface DAOConstants {

	String SELECT_CORSO_CORSISTA = "select * from corso_corsista";
	String SELECT_CORSO_CORSISTA_BYID = "select * from corso_corsista where cod_corso = ?";
	
	String SELECT_TRENDING_CORSO = "select cod_corso, count(*) numero_persone from corso_corsista group by cod_corso";
	
	String SELECT_CORSISTA_SEQ = "select corsista_seq.nextval from dual";
	
	String SELECT_CODADMIN = "Select cod_admin from amministratori where nome_admin = ?";

	String SELECT_CORSISTI = "select * from corsista";
	
	String SELECT_CORSO = "Select * from corso";
	String SELECT_CORSO_BYID = "Select * from corso where cod_corso = ?";
	String DELETE_CORSO = "Delete from corso where cod_corso = ?";
	String SELECT_DOCENTE_CORSI = "Select cod_docente, nome_docente, cognome_docente, cv_docente, cod_corso from corso, docente where corso.docente = docente.cod_docente";
	String SELECT_MEDIA_CORSO = "Select avg(data_fine - data_inizio) from corso";
	String DELETE_CORSO_CORSISTA = "Delete from corso_corsista where cod_corso = ? and cod_corsista = ?";
	
	String DELETE_CORSISTA = "delete from corsista where cod_corsista = ?";
}
