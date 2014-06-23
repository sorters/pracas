package com.pracas.domain.controller;

import com.pracas.persistence.CtrlAdministradorDB;
import com.pracas.persistence.CtrlCasellaDB;
import com.pracas.persistence.CtrlCategoriaDB;
import com.pracas.persistence.CtrlJugadorDB;
import com.pracas.persistence.CtrlParametresDB;
import com.pracas.persistence.CtrlParaulaDB;
import com.pracas.persistence.CtrlPartidaDB;
import com.pracas.persistence.CtrlUsuariRegistratDB;

/*
 *  Classe DataFactory (Singleton)
 *  Conté i serveix els controladors d'accés a dades especificats en els diagrames.
 *  
 *  Observacions/Modificacions:
 *  Tots els controladors són singleton. Tot i que al diagrama no s'explicitava que 
 *  ho fossin, per temes pràctics s'han implementat així, ja que no entra en conflicte
 *  amb el disseny.
 */
public class DataFactory {

	private static DataFactory ctrlDataFactory = null;
	
	private static CtrlAdministradorDB iadmin = null;
	private static CtrlCasellaDB icasella = null;
	private static CtrlCategoriaDB icategoria = null;
	private static CtrlJugadorDB ijugador = null;
	private static CtrlParametresDB iparametres = null;
	private static CtrlParaulaDB iparaula = null;
	private static CtrlPartidaDB ipartida = null;
	private static CtrlUsuariRegistratDB iusuariregistrat = null;
	
	private DataFactory(){};
	
	public static DataFactory getInstance() {
		if (ctrlDataFactory == null)
			ctrlDataFactory = new DataFactory();
		return ctrlDataFactory;
	}
	
	public static ICtrlAdministrador getCtrlAdministrador() {
		if (iadmin == null)
			iadmin = new CtrlAdministradorDB();
		return iadmin;
	}
	public static ICtrlCasella getCtrlCasella() {
		if (icasella == null)
			icasella = new CtrlCasellaDB();
		return icasella;
	}
	public static ICtrlCategoria getCtrlCategoria() {
		if (icategoria == null)
			icategoria = new CtrlCategoriaDB();
		return icategoria;
	}
	public static ICtrlJugador getCtrlJugador() {
		if (ijugador == null)
			ijugador = new CtrlJugadorDB();
		return ijugador;
	}
	public static ICtrlParametres getCtrlParametres() {
		if (iparametres == null)
			iparametres = new CtrlParametresDB();
		return iparametres;
	}
	public static ICtrlParaula getCtrlParaula() {
		if (iparaula == null)
			iparaula = new CtrlParaulaDB();
		return iparaula;
	}
	public static ICtrlPartida getCtrlPartida() {
		if (ipartida == null)
			ipartida = new CtrlPartidaDB();
		return ipartida;
	}
	public static ICtrlUsuariRegistrat getCtrlUsuariRegistrat() {
		if (iusuariregistrat == null)
			iusuariregistrat = new CtrlUsuariRegistratDB();
		return iusuariregistrat;
	}
	
}
