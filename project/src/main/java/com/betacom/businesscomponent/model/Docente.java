package com.betacom.businesscomponent.model;

public class Docente {

	private String nomeDocente;
	private String cognomeDocente;
	private String cvDocente;
	private int codDocente;
	private int codCorso;

	public String getNomeDocente() {
		return nomeDocente;
	}

	public void setNomeDocente(String nomeDocente) {
		this.nomeDocente = nomeDocente;
	}

	public String getCognomeDocente() {
		return cognomeDocente;
	}

	public void setCognomeDocente(String cognomeDocente) {
		this.cognomeDocente = cognomeDocente;
	}

	public String getCvDocente() {
		return cvDocente;
	}

	public void setCvDocente(String cvDocente) {
		this.cvDocente = cvDocente;
	}

	public int getCodDocente() {
		return codDocente;
	}

	public void setCodDocente(int codDocente) {
		this.codDocente = codDocente;
	}

	public int getCodCorso() {
		return codCorso;
	}

	public void setCodCorso(int codCorso) {
		this.codCorso = codCorso;
	}
	
	@Override
	public String toString() {
		return "Docente [nomeDocente=" + nomeDocente + ", cognomeDocente=" + cognomeDocente + ", cvDocente=" + cvDocente
				+ ", codDocente=" + codDocente + ", codCorso=" + codCorso + "]";
	}
}
