package com.pracas.domain.controller;

import com.pracas.persistence.CtrlAdministradorDB;
import com.pracas.persistence.CtrlCasellaDB;
import com.pracas.persistence.CtrlCategoriaDB;
import com.pracas.persistence.CtrlJugadorDB;
import com.pracas.persistence.CtrlParametresDB;
import com.pracas.persistence.CtrlParaulaDB;
import com.pracas.persistence.CtrlPartidaDB;
import com.pracas.persistence.CtrlUsuariRegistratDB;

public class DataFactory {

	private static DataFactory ctrlDataFactory = null;
	
	// els tenim tots a null i retornem on demand havent creat?
	// o retornem sempre un de nou?
	
	private DataFactory(){};
	
	public static DataFactory getInstance() {
		if (ctrlDataFactory == null)
			ctrlDataFactory = new DataFactory();
		return ctrlDataFactory;
	}
	
	public ICtrlAdministrador getCtrlAdministrador() {
		return new CtrlAdministradorDB();
	}
	public ICtrlCasella getCtrlCasella() {
		return new CtrlCasellaDB();
	}
	public ICtrlCategoria getCtrlCategoria() {
		return new CtrlCategoriaDB();
	}
	public ICtrlJugador getCtrlJugador() {
		return new CtrlJugadorDB();
	}
	public ICtrlParametres getCtrlParametres() {
		return new CtrlParametresDB();
	}
	public ICtrlParaula getCtrlParaula() {
		return new CtrlParaulaDB();
	}
	public ICtrlPartida getCtrlPartida() {
		return new CtrlPartidaDB();
	}
	public ICtrlUsuariRegistrat getCtrlUsuariRegistrat() {
		return new CtrlUsuariRegistratDB();
	}
	
}
