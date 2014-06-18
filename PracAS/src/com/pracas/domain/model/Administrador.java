package com.pracas.domain.model;

import javax.persistence.Basic;

public class Administrador extends UsuariRegistrat {

    @Basic
	private String tlfn;

	public String getTlfn() {
		return tlfn;
	}
	public void setTlfn(String tlfn) {
		this.tlfn = tlfn;
	}
	
}
