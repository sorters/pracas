package com.pracas.service;

import com.pracas.client.MailServiceCustomClient;

/*
 * Implementació de l'interficie del servei:
 * 
 * Es solicita el servei al ServiceLocator i s'ordena un enviament a la
 * instancia adquirida.
 */
public class MailServiceAdapter implements IMailServiceAdapter {

	@Override
	public void sendMail(String _message, String _receiver) {
		MailServiceCustomClient mscc = ServiceLocator.getInstance().findMailServiceClient();
		mscc.sendMail(_message, _receiver);
	}

}
