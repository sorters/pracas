package com.pracas.persistence;

import java.text.MessageFormat;
import java.util.Set;

import org.hibernate.Session;

import com.pracas.domain.controller.ICtrlUsuariRegistrat;
import com.pracas.domain.model.Administrador;
import com.pracas.domain.model.UsuariRegistrat;
import com.pracas.exceptions.UsernameNotExistsException;

public class CtrlUsuariRegistratDB implements ICtrlUsuariRegistrat {

	@Override
	public UsuariRegistrat getUsuariRegistrat(String username) throws UsernameNotExistsException {
		Session s = PersistenceSessionFactory.getInstance().getSession();
		UsuariRegistrat result = (UsuariRegistrat)s.get(UsuariRegistrat.class, username);
		if (result == null) {
			throw new UsernameNotExistsException(MessageFormat.format("Username {0} does not exist in database.", username));
		}
		return result;
	}

	@Override
	public Set<UsuariRegistrat> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
