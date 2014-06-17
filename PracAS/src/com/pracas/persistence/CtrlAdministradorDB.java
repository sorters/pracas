package com.pracas.persistence;

import java.util.Set;

import org.hibernate.Session;

import com.pracas.domain.controller.ICtrlAdministrador;
import com.pracas.domain.model.Administrador;

public class CtrlAdministradorDB implements ICtrlAdministrador {

	@Override
	public Administrador getAdministrador(String username) {
		Session s = PersistenceSessionFactory.getInstance().getSession();
		return (Administrador)s.load(Administrador.class, username);
	}

	@Override
	public Set<Administrador> getAll() {
		/*Session s = PersistenceSessionFactory.getInstance().getSession();
		//List list = 
		//List<Administrador> resultList = list;
		return new HashSet<Administrador>(s.createCriteria(Administrador.class).list());
		// TODO wat???*/
		return null;
	}
	
}
