package com.pracas.domain.model;

public class EstrategiaNoPenalitzacio implements IEstrategiaPuntuacio {

	private int puntuacioEncert;
	
	@Override
	public int calcularPuntuacio(int nEncerts, int nErrors) {
		return (nEncerts * puntuacioEncert);
	}

	public void setPuntuacioEncert(int puntuacioEncert) {
		this.puntuacioEncert = puntuacioEncert;
	}
	
}
