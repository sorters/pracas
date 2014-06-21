package com.pracas.transaction;
import com.pracas.domain.controller.DataFactory;
import com.pracas.domain.controller.ICtrlUsuariRegistrat;
import com.pracas.domain.model.UsuariRegistrat;
import com.pracas.exception.UsernameNotExistsException;
import com.pracas.exception.WrongPasswordException;

public class TxLogin {
	
	private String userN;
	private String passwd;
	
	public TxLogin(String userN, String passwd) {
		super();
		this.userN = userN;
		this.passwd = passwd;
	}

	public void executar() throws UsernameNotExistsException, WrongPasswordException {
		ICtrlUsuariRegistrat icur = DataFactory.getCtrlUsuariRegistrat();
		UsuariRegistrat usuari = icur.getUsuariRegistrat(this.userN);
		if (!usuari.checkPassword(this.passwd)) {
			throw new WrongPasswordException();
		}
	}
	
}
