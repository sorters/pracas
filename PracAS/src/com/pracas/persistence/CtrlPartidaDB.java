package com.pracas.persistence;

import java.util.Set;

import org.hibernate.Session;

import com.pracas.domain.controller.ICtrlPartida;
import com.pracas.domain.model.Partida;

public class CtrlPartidaDB implements ICtrlPartida {

	@Override
	public Partida getPartida(int _idPartida) {
		Session s = PersistenceSessionFactory.getInstance().getSession();
		s.beginTransaction();
		Partida result = (Partida)s.get(Partida.class, _idPartida);
		if (result == null) {
			// TODO
		}
		return result;
	}

	public int savePartida(Partida _partida) {
		
		return 0;
	}
	
	@Override
	public Set<Partida> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
