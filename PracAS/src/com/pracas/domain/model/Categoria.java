package com.pracas.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Id;

public class Categoria {
	
    @Id
	private String nom;
    //@OneToMany(mappedBy="")
	//@JoinColumn(name="PARAULA")
	private List<Paraula> paraules;
	
	public Categoria() {
		paraules = new ArrayList<Paraula>();
		// TODO Stub to fill words
	}
	
	public Paraula getParaulaAleatoria() {
		int pos = new Random().nextInt(paraules.size());
		return paraules.get(pos);
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
