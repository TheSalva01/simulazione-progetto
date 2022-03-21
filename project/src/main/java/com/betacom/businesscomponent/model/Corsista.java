package com.betacom.businesscomponent.model;

public class Corsista {
	private long codCorsista;
	private String nomeCorsista;
	private String cognomeCorsista;
	private int precForm;
	
	public long getCodCorsista() {
		return codCorsista;
	}
	
	public void setCodCorsista(long codCorsista) {
		this.codCorsista = codCorsista;
	}
	
	public String getNomeCorsista() {
		return nomeCorsista;
	}
	
	public void setNomeCorsista(String nomeCorsista) {
		this.nomeCorsista = nomeCorsista;
	}
	
	public String getCognomeCorsista() {
		return cognomeCorsista;
	}
	
	public void setCognomeCorsista(String cognomeCorsista) {
		this.cognomeCorsista = cognomeCorsista;
	}
	
	public int getPrecForm() {
		return precForm;
	}
	
	public void setPrecForm(int precForm) {
		this.precForm = precForm;
	}

	@Override
	public String toString() {
		return "Corsista [codCorsista=" + codCorsista + ", nomeCorsista=" + nomeCorsista + ", cognomeCorsista="
				+ cognomeCorsista + ", precForm=" + precForm + "]";
	}
}
