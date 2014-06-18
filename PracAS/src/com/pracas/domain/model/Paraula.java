package com.pracas.domain.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Paraula {

	@Id
	private String nom;
	@Basic
	private int nombreLletres;
	@OneToMany(mappedBy="idPartida")
	private List<Partida> partides;
	
	public Paraula(String _nom) {
		nom = _nom;
		nombreLletres = nom.length();
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getNombreLletres() {
		return nombreLletres;
	}

	
	
}
