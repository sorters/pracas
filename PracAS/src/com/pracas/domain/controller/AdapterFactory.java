package com.pracas.domain.controller;

import com.pracas.domain.model.EstrategiaNoPenalitzacio;
import com.pracas.domain.model.EstrategiaPenalitzacio;
import com.pracas.service.MailServiceAdapter;

/*
 *  Classe AdapterFactory (Singleton)
 *  Conté i serveix els adaptadors (patró adaptador) especificats en els diagrames:
 *  Les dues estrategies diferents (patró estrategia) de puntuació i l'adaptador
 *  del servei d'enviament de correu electrònic.
 *  
 *  Observacions/Modificacions:
 *  Tots els adaptadors són singleton. El disseny ho especifica explícitament per
 *  a l'adaptador del servei.
 *  Tot i que al diagrama no s'explicitava que les estratègies ho fossin, per temes 
 *  pràctics s'han implementat així, ja que no entra en conflicte amb el disseny.
 */

public class AdapterFactory {
	
	private static AdapterFactory instance;
	
	private static EstrategiaPenalitzacio estPen;
	private static EstrategiaNoPenalitzacio estNoPen;
	private static MailServiceAdapter mailServiceAdapter;
	
	private AdapterFactory() {}
	
	public static AdapterFactory getInstance() {
		if (instance == null)
			instance = new AdapterFactory();
		return instance;
	}

	public static EstrategiaPenalitzacio getEstrategiaPenalitzacio() {
		if (estPen == null)
			estPen = new EstrategiaPenalitzacio();
		return estPen;
	}

	public static EstrategiaNoPenalitzacio getEstrategiaNoPenalitzacio() {
		if (estNoPen == null)
			estNoPen = new EstrategiaNoPenalitzacio();
		return estNoPen;
	}

	public static MailServiceAdapter getMailService() {
		if (mailServiceAdapter == null)
			mailServiceAdapter = new MailServiceAdapter();
		return mailServiceAdapter;
	}
	
}
