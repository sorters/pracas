package com.pracas.persistence;

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
	public int saveOrUpdateJugador(Jugador _jugador) {
		Session s = PersistenceSessionFactory.getInstance().openSession();
		s.beginTransaction();
		s.saveOrUpdate(_jugador);
		s.getTransaction().commit();
		s.close();
		return 0;
	}
	
}
