package com.betacom.businesscomponent.facade;

import java.util.Date;
import java.util.List;

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

	public void createCorsista(Corsista corsista) {
		// TODO: Implement this method
		throw new UnsupportedOperationException();
	}

	public void deleteCorso(Corso corso) {
		// TODO: Implement this method
		throw new UnsupportedOperationException();
	}

	public List<Corsista> getCorsisti() {
		// TODO: Implement this method
		throw new UnsupportedOperationException();
	}

	public int getNumber() {
		// TODO: Implement this method
		throw new UnsupportedOperationException();
	}

	public Corso getTrendCourse() {
		// TODO: Implement this method
		throw new UnsupportedOperationException();
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
