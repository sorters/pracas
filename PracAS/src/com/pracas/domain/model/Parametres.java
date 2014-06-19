package com.pracas.domain.model;

public class Parametres {

	private static Parametres instance;
	
	private static int nombreMaximErrors;
	private static int idPartida;
	
	private Parametres() {
		idPartida = 0;
	}
	
	public static Parametres getInstance() {
		if (instance == null)
			instance = new Parametres();
		return instance;
	}

	public static int getNombreMaximErrors() {
		return nombreMaximErrors;
	}
	public static void setNombreMaximErrors(int _nombreMaximErrors) {
		nombreMaximErrors = _nombreMaximErrors;
	}
	
	public static int getIdPartida() {
		idPartida++;
		return idPartida;
	}
	public static void setIdPartida(int _idPartida) {
		idPartida = _idPartida;
	}
	
	
	
}
