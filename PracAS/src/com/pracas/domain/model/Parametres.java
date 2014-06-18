package com.pracas.domain.model;

public class Parametres {

	private static Parametres instance;
	
	private int nombreMaximErrors;
	private int idPartida;
	
	private Parametres() {
		idPartida = 0;
	}
	
	public static Parametres getInstance() {
		if (instance == null)
			instance = new Parametres();
		return instance;
	}

	public int getNombreMaximErrors() {
		return nombreMaximErrors;
	}
	public void setNombreMaximErrors(int nombreMaximErrors) {
		this.nombreMaximErrors = nombreMaximErrors;
	}
	
	public int getIdPartida() {
		idPartida++;
		return idPartida;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	
	
	
}
