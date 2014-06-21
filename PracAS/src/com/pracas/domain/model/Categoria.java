package com.pracas.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.pracas.exception.CategoryHasNoWordsException;

@Entity
public class Categoria {
	
    @Id
	private String nomC;
    @OneToMany
	private List<Paraula> paraules;
	
    public Categoria() {}
    
	public Categoria(String _nom) {
		nomC = _nom;
		paraules = new ArrayList<Paraula>();
	}
	
	public void afegeixParaula(Paraula _p) {
		paraules.add(_p);
	}
	
	public Paraula getParaulaAleatoria() throws CategoryHasNoWordsException {
		int pos = 0;
		if (paraules.size() > 0) {
			pos = new Random().nextInt(paraules.size());
		} else {
			throw new CategoryHasNoWordsException();
		}
		return paraules.get(pos);
	}
	
	public String getNom() {
		return nomC;
	}
	public void setNom(String _nom) {
		this.nomC = _nom;
	}
}
