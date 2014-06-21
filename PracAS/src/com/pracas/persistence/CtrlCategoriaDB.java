package com.pracas.persistence;

import java.util.List;

import org.hibernate.Session;

import com.pracas.domain.controller.ICtrlCategoria;
import com.pracas.domain.model.Categoria;
import com.pracas.exception.CategoryHasNoWordsException;

public class CtrlCategoriaDB implements ICtrlCategoria {

	@Override
	public Categoria getCategoria(String nom) {
		Session s = PersistenceSessionFactory.getInstance().openSession();
		Categoria response = (Categoria)s.get(Categoria.class, nom);
		try {
			response.getParaulaAleatoria();
		} catch (CategoryHasNoWordsException ignore) {} // hack to avoid lazy load exception
		s.close();
		return response;
	}

	@Override
	public List<Categoria> getAll() {
		Session s = PersistenceSessionFactory.getInstance().openSession();
		List<Categoria> response = s.createCriteria(Categoria.class).list();
		return response;
	}

}
