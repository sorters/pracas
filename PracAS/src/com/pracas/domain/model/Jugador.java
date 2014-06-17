package com.pracas.domain.model;

import java.util.Set;

public class Jugador extends UsuariRegistrat {

	private String email;
	private Partida partidaActual;
	private Set<Partida> partidesJugades; 

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
	
	
}
