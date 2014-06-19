package com.pracas.domain.controller;

import com.pracas.domain.model.EstrategiaNoPenalitzacio;
import com.pracas.domain.model.EstrategiaPenalitzacio;
import com.pracas.service.MailServiceAdapter;

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
