package com.pracas.domain.model;

import javax.persistence.Basic;

public class Administrador extends UsuariRegistrat {

	@Basic
	private String tlfn;

    public Administrador(String _nom, String _cognom, String _username, String _pwd) {
		super(_nom, _cognom, _username, _pwd);
		// TODO Auto-generated constructor stub
	}
	
	public String getTlfn() {
		return tlfn;
	}
	public void setTlfn(String tlfn) {
		this.tlfn = tlfn;
	}
	
}
