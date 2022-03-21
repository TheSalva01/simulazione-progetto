package com.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.betacom.architecture.dao.CorsoDAO;
import com.betacom.architecture.dao.DAOException;
import com.betacom.architecture.dbaccess.DBAccess;
import com.betacom.businesscomponent.model.Corso;
import com.betacom.businesscomponent.model.CorsoCorsista;
import com.betacom.businesscomponent.model.Docente;
import com.betacom.businesscomponent.utility.DateComparator;

public class CorsoBC {
	private Connection conn;
	
	public static CorsoBC getFactory() throws DAOException, ClassNotFoundException, IOException {
		return new CorsoBC();
	}

	public CorsoBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void create(Corso corso) throws DAOException {
				CorsoDAO.getFactory().create(conn, corso);
		}
	
	public List<Corso> getCorsi() throws DAOException {
		try {
			return CorsoDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Date getLastDate() throws DAOException {
			List<Corso> lista = getCorsi();	
			lista.sort(new DateComparator());
			return lista.get(lista.size() - 1).getDataInizioCorso();
	}
	
	
	public int getMidLenght() throws DAOException {
		try{
			return CorsoDAO.getFactory().getAVGDay(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public int getComment() throws DAOException {
		try {
			return getCorsi().size();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public List<Docente> getTeacherCourses() throws DAOException {
		List<Integer> lista = new ArrayList<>();
		List<Docente> listaD = new ArrayList<>();
		for (Docente docente : CorsoDAO.getFactory().getDocenti(conn)) {
			if(lista.contains(docente.getCodDocente()) ) {
				listaD.add(docente);
			} else {
				lista.add(docente.getCodDocente());
			}
		}
		return listaD;
	}
	
	public int getSlotAvailable(Corso corso) throws DAOException, ClassNotFoundException, IOException {
		try {
			CorsoCorsistaBC cBC = new CorsoCorsistaBC();
			int posti = 12;
			for (CorsoCorsista corsoCorsista : cBC.getAll()) {
				if (corsoCorsista.getCodCorso() == corso.getCodCorso()) {
					posti--;
				}
			}
			return posti;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public List<Corso> getCorsiAvailable() throws DAOException, ClassNotFoundException, IOException {
		List<Corso> lista = new ArrayList<>();
		for (Corso corso : getCorsi()) {
			if (getSlotAvailable(corso) > 0) {
				lista.add(corso);
			}
		}
		return lista;
	}
	
	
	public void delete(Corso corso) throws DAOException {
		try {
			CorsoDAO.getFactory().delete(conn, corso);			
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
}