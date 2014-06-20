package com.pracas.domain.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Paraula {

	@Id
	private String nomP;
	@Basic
	private int nombreLletres;
	
	public Paraula(String _nom) {
		nomP = _nom;
		nombreLletres = nomP.length();
	}
	
	public String getNom() {
		return nomP;
	}
	
	public int getNombreLletres() {
		return nombreLletres;
	}
	


	
	
}
