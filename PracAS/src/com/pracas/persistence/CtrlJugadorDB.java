package com.pracas.persistence;

import java.util.Set;

import org.hibernate.Session;

import com.pracas.domain.controller.ICtrlJugador;
import com.pracas.domain.model.Jugador;

public class CtrlJugadorDB implements ICtrlJugador {

	@Override
	public boolean exists(String nom) {
		return (this.getJugador(nom) != null);
	}

	@Override
	public Jugador getJugador(String username) {
		Session s = PersistenceSessionFactory.getInstance().openSession();
		Jugador response = (Jugador)s.get(Jugador.class, username);
		s.close();
		return response;
	}

	@Override
	public Set<Jugador> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
