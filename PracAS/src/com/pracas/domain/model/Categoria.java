package com.pracas.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria {
	
    @Id
	private String nomC;
    @OneToMany
	private List<Paraula> paraules;
	
	public Categoria(String _nom) {
		nomC = _nom;
		paraules = new ArrayList<Paraula>();
	}
	
	public void afegeixParaula(Paraula _p) {
		paraules.add(_p);
	}
	
	public Paraula getParaulaAleatoria() {
		int pos = new Random().nextInt(paraules.size());
		return paraules.get(pos);
	}
	
	public String getNom() {
		return nomC;
	}
	public void setNom(String _nom) {
		this.nomC = _nom;
	}
}
