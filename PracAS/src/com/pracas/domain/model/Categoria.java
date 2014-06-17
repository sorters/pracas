package com.pracas.domain.model;

import java.util.Random;
import java.util.Set;

public class Categoria {
	
	private String nom;
	private Set<Paraula> paraules;
	
	public Paraula getParaulaAleatoria() {
		int pos = new Random().nextInt(paraules.size());
		int i = 0;
		for (Paraula p : paraules) {
			if (i == pos) {
				return p;
			}
			i++;
		}
		return null;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
