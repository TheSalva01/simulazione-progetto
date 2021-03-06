package com.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.betacom.architecture.dao.CorsoCorsistaDAO;
import com.betacom.architecture.dao.CorsoDAO;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.model.Corso;
import com.betacom.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaBC {
	private Connection conn; 
	
	public CorsoCorsistaBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void create(CorsoCorsista corsoCorsista) throws DAOException {
		CorsoCorsistaDAO.getFactory().create(conn, corsoCorsista);
	}
	
	public Corso getTrendCourse() throws DAOException {
		int trendingCourseId = CorsoCorsistaDAO.getFactory().getTrendCourseId(conn);
		Corso corso = CorsoDAO.getFactory().getById(conn, trendingCourseId); 
		
		return corso; 
	}
	
	public List<CorsoCorsista> getAll() throws DAOException {
		return CorsoCorsistaDAO.getFactory().getAll(conn);
	}
	
	public List<Corso> getCorsiByCorsista(long idCorsista) throws DAOException {
		List<Corso> corsi = new ArrayList<>(); 
		
		for(CorsoCorsista corsoCorsista : getAll()) {
			if(corsoCorsista.getCodCorsista() == idCorsista) {
				Corso corso = CorsoDAO.getFactory().getById(conn, corsoCorsista.getCodCorso());
				corsi.add(corso);
			}
		}
		
		return corsi; 
	}
	
	public void delete(CorsoCorsista corsoCorsista) throws DAOException {
		CorsoCorsistaDAO.getFactory().delete(conn, corsoCorsista);
	}
}
