package com.betacom.businesscomponent.facade;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.betacom.architecture.dao.DAOException;
import com.betacom.businesscomponent.CorsistaBC;
import com.betacom.businesscomponent.CorsoBC;
import com.betacom.businesscomponent.CorsoCorsistaBC;
import com.betacom.businesscomponent.model.Corsista;
import com.betacom.businesscomponent.model.Corso;
import com.betacom.businesscomponent.model.CorsoCorsista;
import com.betacom.businesscomponent.model.Docente;

public class AdminFacade {
	private static AdminFacade adminFacade;

	public static AdminFacade getInstance() {
		if (adminFacade == null) {
			adminFacade = new AdminFacade();
		}
		return adminFacade;
	}

	public void createCorsista(Corsista corsista, Corso corso) throws DAOException, ClassNotFoundException, IOException {
		CorsistaBC corsistaBC = new CorsistaBC();
		CorsoCorsistaBC corsoCorsistaBC = new CorsoCorsistaBC(); 
		
		long idCorso = corso.getCodCorso();
		Corsista c = corsistaBC.create(corsista);
		
		CorsoCorsista corsoCorsista = new CorsoCorsista();
		corsoCorsista.setCodCorso(idCorso);
		corsoCorsista.setCodCorsista(corsista.getCodCorsista());
		
		corsoCorsistaBC.create(corsoCorsista);
	}

	public void deleteCorso(Corso corso) throws DAOException, ClassNotFoundException, IOException {
		CorsoBC corsoBC = new CorsoBC();
		
		corsoBC.delete(corso);
	}

	public List<Corsista> getCorsisti() throws DAOException, ClassNotFoundException, IOException {
		CorsistaBC cBC = new CorsistaBC();
		return cBC.getAll();
	}

	public int getNumber() throws DAOException, ClassNotFoundException, IOException {
		CorsistaBC cBC = new CorsistaBC();
		return cBC.getNumber();
	}

	public Corso getTrendCourse() throws DAOException, ClassNotFoundException, IOException {
		CorsoCorsistaBC corsoCorsistaBC = new CorsoCorsistaBC();
		return corsoCorsistaBC.getTrendCourse();
	}

	public Date getLastDate() throws DAOException, ClassNotFoundException, IOException {
		CorsoBC corsoBC = new CorsoBC(); 
		return corsoBC.getLastDate();
	}

	public int getMidLength() throws ClassNotFoundException, IOException, SQLException {
		CorsoBC corsoBC = new CorsoBC(); 
		return corsoBC.getMidLenght();
	}

	public int getComment() throws ClassNotFoundException, IOException, SQLException {
		CorsoBC corsoBC = new CorsoBC();
		return corsoBC.getComment(); 
	}

	public List<Docente> getTeacherCourses() throws ClassNotFoundException, IOException, SQLException {
		CorsoBC corsoBC = new CorsoBC();
		return corsoBC.getTeacherCourses();
	}

	public int getSlotsAvailable(Corso corso) throws DAOException, ClassNotFoundException, IOException {
		CorsoBC corsoBC = new CorsoBC();
		
		return corsoBC.getSlotAvailable(corso);
	}

}
