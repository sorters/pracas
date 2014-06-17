package com.pracas.domain.controller;

import com.pracas.domain.model.EstrategiaNoPenalitzacio;
import com.pracas.domain.model.EstrategiaPenalitzacio;
import com.pracas.service.MailServiceAdapter;

public class AdapterFactory {
	
	private static AdapterFactory instance;
	
	private EstrategiaPenalitzacio estPen;
	private EstrategiaNoPenalitzacio estNoPen;
	private MailServiceAdapter mailServiceAdapter;
	
	private AdapterFactory() {}
	
	public static AdapterFactory getInstance() {
		if (instance == null)
			instance = new AdapterFactory();
		return instance;
	}

	public EstrategiaPenalitzacio getEstrategiaPenalitzacio() {
		return estPen;
	}

	public EstrategiaNoPenalitzacio getEstrategiaNoPenalitzacio() {
		return estNoPen;
	}

	public MailServiceAdapter getMailService() {
		return mailServiceAdapter;
	}
	
}
