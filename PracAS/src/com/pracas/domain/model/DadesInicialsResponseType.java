package com.pracas.domain.model;

public class DadesInicialsResponseType {

	private int puntuacioInicial;
	private int nombreMaximErrors;
	private int puntuacioPerEncert;
	private int puntuacioPerError;
	
	public DadesInicialsResponseType(int puntuacioInicial, int nombreMaximErrors, int puntuacioPerEncert, int puntuacioPerError) {
		super();
		this.puntuacioInicial = puntuacioInicial;
		this.nombreMaximErrors = nombreMaximErrors;
		this.puntuacioPerEncert = puntuacioPerEncert;
		this.puntuacioPerError = puntuacioPerError;
	}

	public int getPuntuacioInicial() {
		return puntuacioInicial;
	}

	public void setPuntuacioInicial(int puntuacioInicial) {
		this.puntuacioInicial = puntuacioInicial;
	}

	public int getNombreMaximErrors() {
		return nombreMaximErrors;
	}

	public void setNombreMaximErrors(int nombreMaximErrors) {
		this.nombreMaximErrors = nombreMaximErrors;
	}

	public int getPuntuacioPerEncert() {
		return puntuacioPerEncert;
	}

	public void setPuntuacioPerEncert(int puntuacioPerEncert) {
		this.puntuacioPerEncert = puntuacioPerEncert;
	}

	public int getPuntuacioPerError() {
		return puntuacioPerError;
	}

	public void setPuntuacioPerError(int puntuacioPerError) {
		this.puntuacioPerError = puntuacioPerError;
	}
	
}
