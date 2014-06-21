package com.pracas.service;

import com.pracas.client.MailServiceCustomClient;

public class MailServiceAdapter implements IMailServiceAdapter {

	@Override
	public void sendMail(String _message, String _receiver) {
		MailServiceCustomClient.sendMail(_message, _receiver);
	}

}
