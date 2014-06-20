package com.pracas.domain.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Jugador extends UsuariRegistrat {
	
	@Basic
	private String email;
	@Basic
	private Partida partidaActual;
    @OneToMany
	//@JoinColumn(name="PARTIDA_JUGADA")
	private List<Partida> partidesJugades; 

	public Jugador(String _nom, String _cognom, String _username, String _pwd) {
		super(_nom, _cognom, _username, _pwd);
		// TODO Auto-generated constructor stub
	}

	public Jugador(UsuariRegistrat _usr, String _email) {
		super(_usr.getNom(), _usr.getCognom(), _usr.getUsername(), _usr.getPwd());
		email = _email;
		// TODO Auto-generated constructor stub
	}
	
	public boolean getMes2PartidesGuanyades() {
		int cont = 0;
		for (Partida p : partidesJugades) {
			if (p.isGuanyada())
				cont++;
			if (cont == 2) 
				break;
		}
		return (cont >= 2);
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Partida getPartidaActual() {
		return partidaActual;
	}
	public void setPartidaActual(Partida partidaActual) {
		this.partidaActual = partidaActual;
	}
	
	
}
