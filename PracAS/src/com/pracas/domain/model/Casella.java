package com.pracas.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Casella {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCasella;
	@Basic
	private int posicio;
	@Transient
	private Lletra lletraCorrecta;
	@Transient
	private boolean encert;
	@Transient
	private List<Lletra> lletresErronies;
	
	public Casella(int _posicio, Lletra _lletraCorrecta) {
		super();
		posicio = _posicio;
		lletraCorrecta = _lletraCorrecta;
		encert = false;
		lletresErronies = new ArrayList<Lletra>();
	}
	
	public boolean intentarLletra(Lletra lletra) {
		if (lletra == lletraCorrecta) {
			encert = true;
		} else {
			lletresErronies.add(lletra);
		}
		return encert;
	}
	
	public int getPosicio() {
		return posicio;
	}
	public void setPosicio(int posicio) {
		this.posicio = posicio;
	}
	
	public Lletra getLletraCorrecta() {
		return lletraCorrecta;
	}
	public void setLletraCorrecta(Lletra lletraCorrecta) {
		this.lletraCorrecta = lletraCorrecta;
	}
	
	public boolean isEncert() {
		return encert;
	}
	public void setEncert(boolean encert) {
		this.encert = encert;
	}
	
	public List<Lletra> getLletresErronies() {
		return lletresErronies;
	}
	public void setLletresErronies(List<Lletra> lletresErronies) {
		this.lletresErronies = lletresErronies;
	}
	
	
	
}
