package com.pracas.domain.model;

import java.util.List;
import java.util.Random;

import javax.persistence.Id;

public class Categoria {
	
    @Id
	private String nom;
        
    //@OneToMany(mappedBy="")
	//@JoinColumn(name="PARAULA")
	private List<Paraula> paraules;
	
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
