package com.pracas.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pracas.domain.controller.DataFactory;
import com.pracas.domain.controller.ICtrlJugador;

@Entity
@Table(name="JUGADOR")
public class Jugador extends UsuariRegistrat {
	
	@Basic
	private String email;
	@ManyToOne
	private Partida partidaActual;
	@OneToMany(fetch=FetchType.EAGER)
	private List<Partida> partidesJugades; 

    public Jugador() {}
	
	public Jugador(UsuariRegistrat _usr, String _email) {
		super(new String(_usr.getNom()), _usr.getCognom(), _usr.getUsername(), _usr.getPwd());
		email = _email;
		partidesJugades = new ArrayList<Partida>();
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
	
	public void finalitzarPartida() {
		partidesJugades.add(partidaActual);
		partidaActual = null;
		ICtrlJugador icj = DataFactory.getCtrlJugador();
		icj.saveOrUpdateJugador(this);
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
