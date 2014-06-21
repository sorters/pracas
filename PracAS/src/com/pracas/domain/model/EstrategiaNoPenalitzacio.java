package com.pracas.domain.model;


public class EstrategiaNoPenalitzacio implements IEstrategiaPuntuacio {

	private int puntuacioEncert;
	private int puntuacioError;
	
	@Override
	public int calcularPuntuacio(int nEncerts, int nErrors) {
		return (nEncerts * puntuacioEncert);
	}

	public int getPuntuacioEncert() {
		return puntuacioEncert;
	}
	public void setPuntuacioEncert(int puntuacioEncert) {
		this.puntuacioEncert = puntuacioEncert;
	}

	public int getPuntuacioError() {
		return puntuacioError;
	}
	public void setPuntuacioError(int puntuacioError) {
		this.puntuacioError = puntuacioError;
	}
	
}
