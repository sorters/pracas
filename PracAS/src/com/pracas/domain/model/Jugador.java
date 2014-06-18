package com.pracas.domain.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Jugador extends UsuariRegistrat {

	@Basic
	private String email;
	@Basic
	private Partida partidaActual;
    @OneToMany
	@JoinColumn(name="PARTIDA_JUGADA")
	private List<Partida> partidesJugades; 

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
