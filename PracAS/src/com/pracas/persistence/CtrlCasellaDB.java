package com.pracas.persistence;

import java.util.Set;

import org.hibernate.Session;

import com.pracas.domain.controller.ICtrlCasella;
import com.pracas.domain.model.Casella;
import com.pracas.domain.model.Partida;

public class CtrlCasellaDB implements ICtrlCasella {

	@Override
	public Casella getCasella(int posicio, int idPartida) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveOrUpdateCasella(Casella _casella) {
		Session s = PersistenceSessionFactory.getInstance().openSession();
		s.beginTransaction();
		s.saveOrUpdate(_casella);
		s.getTransaction().commit();
		s.close();
		return 0;
	}
	
	@Override
	public Set<Casella> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
