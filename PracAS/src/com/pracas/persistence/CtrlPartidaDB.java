package com.pracas.persistence;

import java.util.List;

import org.hibernate.Session;

import com.pracas.domain.controller.ICtrlPartida;
import com.pracas.domain.model.Partida;

public class CtrlPartidaDB implements ICtrlPartida {

	@Override
	public Partida getPartida(int _idPartida) {
		Session s = PersistenceSessionFactory.getInstance().openSession();
		s.beginTransaction();
		Partida result = (Partida)s.get(Partida.class, _idPartida);
		s.close();
		if (result == null) {
			// TODO decide where to process this.
		}
		return result;
	}

	@Override
	public int saveOrUpdatePartida(Partida _partida) {
		Session s = PersistenceSessionFactory.getInstance().openSession();
		s.beginTransaction();
		s.saveOrUpdate(_partida);
		s.getTransaction().commit();
		s.close();
		return 0;
	}
	
	@Override
	public List<Partida> getAll() {
		Session s = PersistenceSessionFactory.getInstance().openSession();
		List<Partida> response = s.createCriteria(Partida.class).list();
		return response;
	}

	@Override
	public int getLastId() {
		return this.getAll().size();
	}
	
	

}
