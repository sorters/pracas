package com.pracas.persistence;

import java.util.Set;

import org.hibernate.Session;

import com.pracas.domain.controller.ICtrlParaula;
import com.pracas.domain.model.Paraula;

public class CtrlParaulaDB implements ICtrlParaula {

	@Override
	public Paraula getParaula(String nom) {
		Session s = PersistenceSessionFactory.getInstance().openSession();
		Paraula response = (Paraula)s.get(Paraula.class, nom);
		s.close();
		return response;
	}

	@Override
	public Set<Paraula> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
