package com.pracas.persistence;

import java.util.Set;

import org.hibernate.Session;

import com.pracas.domain.controller.ICtrlAdministrador;
import com.pracas.domain.model.Administrador;

public class CtrlAdministradorDB implements ICtrlAdministrador {

	@Override
	public Administrador getAdministrador(String username) {
		Session s = PersistenceSessionFactory.getInstance().openSession();
		Administrador response = (Administrador)s.get(Administrador.class, username);
		return response;
	}

	@Override
	public Set<Administrador> getAll() {
		return null;
	}
	
}
