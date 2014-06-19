package com.pracas.domain.model;

public interface IEstrategiaPuntuacio {
	
	public int calcularPuntuacio(int nEncerts, int nErrors);
	
	public int getPuntuacioEncert();
	public int getPuntuacioError();
	
}
