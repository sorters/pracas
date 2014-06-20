package com.pracas.domain.model;

public class JugadaResponseType {

	private boolean encert;
	private boolean acabada;
	private boolean guanyada;
	private int puntuacio;
	private int errors;
	
	public JugadaResponseType(boolean encert, boolean acabada,
			boolean guanyada, int puntuacio, int errors) {
		super();
		this.encert = encert;
		this.acabada = acabada;
		this.guanyada = guanyada;
		this.puntuacio = puntuacio;
		this.errors = errors;
	}

	public boolean isEncert() {
		return encert;
	}

	public void setEncert(boolean encert) {
		this.encert = encert;
	}

	public boolean isAcabada() {
		return acabada;
	}

	public void setAcabada(boolean acabada) {
		this.acabada = acabada;
	}

	public boolean isGuanyada() {
		return guanyada;
	}

	public void setGuanyada(boolean guanyada) {
		this.guanyada = guanyada;
	}

	public int getPuntuacio() {
		return puntuacio;
	}

	public void setPuntuacio(int puntuacio) {
		this.puntuacio = puntuacio;
	}

	public int getErrors() {
		return errors;
	}

	public void setErrors(int errors) {
		this.errors = errors;
	}
	
}
