package com.betacom.businesscomponent.model;

import java.util.Date;

public class Corso {
	private long codCorso;
	private String nomeCorso;
	private Date dataInizioCorso;
	private Date dataFineCorso;
	private double costoCorso;
	private String commentiCorso;
	private String aulaCorso;
	private int docente;
	
	public int getDocente() {
		return docente;
	}

	public void setDocente(int docente) {
		this.docente = docente;
	}

	public long getCodCorso() {
		return codCorso;
	}
	
	public void setCodCorso(long codCorso) {
		this.codCorso = codCorso;
	}
	
	public String getNomeCorso() {
		return nomeCorso;
	}
	
	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}
	
	public Date getDataInizioCorso() {
		return dataInizioCorso;
	}
	
	public void setDataInizioCorso(Date dataInizioCorso) {
		this.dataInizioCorso = dataInizioCorso;
	}
	
	public Date getDataFineCorso() {
		return dataFineCorso;
	}
	
	public void setDataFineCorso(Date dataFineCorso) {
		this.dataFineCorso = dataFineCorso;
	}
	
	public double getCostoCorso() {
		return costoCorso;
	}
	
	public void setCostoCorso(double costoCorso) {
		this.costoCorso = costoCorso;
	}
	
	
	public String getCommentiCorso() {
		return commentiCorso;
	}

	public void setCommentiCorso(String commentiCorso) {
		this.commentiCorso = commentiCorso;
	}

	public String getAulaCorso() {
		return aulaCorso;
	}
	
	public void setAulaCorso(String aulaCorso) {
		this.aulaCorso = aulaCorso;
	}

	@Override
	public String toString() {
		return "Corso [codCorso=" + codCorso + ", nomeCorso=" + nomeCorso + ", dataInizioCorso=" + dataInizioCorso
				+ ", dataFineCorso=" + dataFineCorso + ", costoCorso=" + costoCorso + ", commentiCorso=" + commentiCorso
				+ ", aulaCorso=" + aulaCorso + ", docente=" + docente + "]";
	}
}
