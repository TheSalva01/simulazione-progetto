package com.betacom.businesscomponent.facade;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.betacom.architecture.dao.DAOException;
import com.betacom.businesscomponent.CorsistaBC;
import com.betacom.businesscomponent.CorsoCorsistaBC;
import com.betacom.businesscomponent.model.Corsista;
import com.betacom.businesscomponent.model.Corso;
import com.betacom.businesscomponent.model.Docente;

public class AdminFacade {
	private static AdminFacade adminFacade;

	public static AdminFacade getInstance() {
		if (adminFacade == null) {
			adminFacade = new AdminFacade();
		}
		return adminFacade;
	}

	/* devo popolare la tabella Corsista ma anche quella CorsoCorsista */
	public void createCorsista(Corsista corsista, Corso corso) throws DAOException, ClassNotFoundException, IOException {
		// TODO: Implement this method
		throw new UnsupportedOperationException();
	}

	public void deleteCorso(Corso corso) {
		// TODO: Implement this method
		throw new UnsupportedOperationException();
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

	public Date getLastDate() {
		// TODO: Implement this method
		throw new UnsupportedOperationException();
	}

	public int getMidLength() {
		// TODO: Implement this method
		throw new UnsupportedOperationException();
	}

	public String getComment() {
		// TODO: Implement this method
		throw new UnsupportedOperationException();
	}

	public List<Docente> getTeacherCourses() {
		// TODO: Implement this method
		throw new UnsupportedOperationException();
	}

	public int getSlotsAvailable() {
		// TODO: Implement this method
		throw new UnsupportedOperationException();
	}

}
