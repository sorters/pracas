package com.pracas.service;

import com.pracas.client.MailServiceCustomClient;

/*
 * Service Locator (Singleton)
 * 
 * Conté i serveix el client del Servei de correu electrònic.
 * 
 */
public class ServiceLocator {

	private static ServiceLocator instance;
	
	private ServiceLocator() {}
	
	public static ServiceLocator getInstance() {
		if (instance == null) {
			instance = new ServiceLocator();
		}
		return instance;
	}
	
	public MailServiceCustomClient findMailServiceClient() {
		return new MailServiceCustomClient();
	}
	
}
